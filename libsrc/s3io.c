/*********************************************************************
*    Copyright 2018, UCAR/Unidata
*    See netcdf/COPYRIGHT file for copying and redistribution conditions.
* ********************************************************************/

#if HAVE_CONFIG_H
#include <config.h>
#endif

#include <assert.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#ifdef HAVE_FCNTL_H
#include <fcntl.h>
#endif
#ifdef _MSC_VER /* Microsoft Compilers */
#include <io.h>
#endif
#ifdef HAVE_UNISTD_H
#include <unistd.h>
#endif
#include "nc3internal.h"

#undef DEBUG

#ifdef DEBUG
#include <stdio.h>
#endif

#include <curl/curl.h>

#include "ncio.h"
#include "fbits.h"
#include "rnd.h"
#include "ncbytes.h"
#include "ncs3.h"

#define DEFAULTPAGESIZE 16384

/* Private data for s3 */

typedef struct NCS3IO {
    CURL* curl; /* curl handle */
    long long size; /* of the S3 object */
    NCbytes* region;
} NCS3IO;

/* Forward */
static int s3io_rel(ncio *const nciop, off_t offset, int rflags);
static int s3io_get(ncio *const nciop, off_t offset, size_t extent, int rflags, void **const vpp);
static int s3io_move(ncio *const nciop, off_t to, off_t from, size_t nbytes, int rflags);
static int s3io_sync(ncio *const nciop);
static int s3io_filesize(ncio* nciop, off_t* filesizep);
static int s3io_pad_length(ncio* nciop, off_t length);
static int s3io_close(ncio* nciop, int);

static long pagesize = 0;

/* Create a new ncio struct to hold info about the file. */
static int
s3io_new(const char* path, int ioflags, ncio** nciopp, NCS3IO** s3p)
{
    int status = NC_NOERR;
    ncio* nciop = NULL;
    NCS3IO* s3io = NULL;

    if(pagesize == 0)
        pagesize = DEFAULTPAGESIZE;
    errno = 0;

    nciop = (ncio* )calloc(1,sizeof(ncio));
    if(nciop == NULL) {status = NC_ENOMEM; goto fail;}
    
    nciop->ioflags = ioflags;

    *((char**)&nciop->path) = strdup(path);
    if(nciop->path == NULL) {status = NC_ENOMEM; goto fail;}

    *((ncio_relfunc**)&nciop->rel) = s3io_rel;
    *((ncio_getfunc**)&nciop->get) = s3io_get;
    *((ncio_movefunc**)&nciop->move) = s3io_move;
    *((ncio_syncfunc**)&nciop->sync) = s3io_sync;
    *((ncio_filesizefunc**)&nciop->filesize) = s3io_filesize;
    *((ncio_pad_lengthfunc**)&nciop->pad_length) = s3io_pad_length;
    *((ncio_closefunc**)&nciop->close) = s3io_close;

    s3io = (NCS3IO*)calloc(1,sizeof(NCS3IO));
    if(s3io == NULL) {status = NC_ENOMEM; goto fail;}
    *((void* *)&nciop->pvt) = s3io;

    if(nciopp) *nciopp = nciop;
    if(s3p) *s3p = s3io;

done:
    return status;

fail:
    if(s3io != NULL) {
	if(s3io->region)
	    ncbytesfree(s3io->region);
	free(s3io);
    }
    if(nciop != NULL) {
        if(nciop->path != NULL) free((char*)nciop->path);
    }
    goto done;
}

/* Create a file, and the ncio struct to go with it. This function is
   only called from nc__create_mp.

   path - path of file to create.
   ioflags - flags from nc_create
   initialsz - From the netcdf man page: "The argument
   Iinitialsize sets the initial size of the file at creation time."
   igeto - 
   igetsz - 
   sizehintp - the size of a page of data for buffered reads and writes.
   nciopp - pointer to a pointer that will get location of newly
   created and inited ncio struct.
   mempp - pointer to pointer to the initial memory read.
*/
int
s3io_create(const char* path, int ioflags,
    size_t initialsz,
    off_t igeto, size_t igetsz, size_t* sizehintp,
    void* parameters,
    ncio* *nciopp, void** const mempp)
{
    return NC_EPERM;
}

/* This function opens the data file. It is only called from nc.c,
   from nc__open_mp and nc_delete_mp.

   path - path of data file.
   ioflags - flags passed into nc_open.
   igeto - looks like this function can do an initial page get, and
   igeto is going to be the offset for that. But it appears to be
   unused 
   igetsz - the size in bytes of initial page get (a.k.a. extent). Not
   ever used in the library.
   sizehintp - the size of a page of data for buffered reads and writes.
   nciopp - pointer to pointer that will get address of newly created
   and inited ncio struct.
   mempp - pointer to pointer to the initial memory read.
*/
int
s3io_open(const char* path,
    int ioflags,
    /* ignored */ off_t igeto, size_t igetsz, size_t* sizehintp,
    /* ignored */ void* parameters,
    ncio* *nciopp,
    /* ignored */ void** const mempp)
{
    ncio* nciop;
    int status;
    NCS3IO* s3io = NULL;
    size_t sizehint;

    if(path == NULL ||* path == 0)
        return EINVAL;

    /* Create private data */
    if((status = s3io_new(path, ioflags, &nciop, &s3io))) goto done;

    /* Open the path and get curl handle and object size */
    if((status = nc_s3_open(path,&s3io->curl,&s3io->size))) goto done;

    sizehint = pagesize;

    /* sizehint must be multiple of 8 */
    sizehint = (sizehint / 8) * 8;
    if(sizehint < 8) sizehint = 8;

    *sizehintp = sizehint;
    *nciopp = nciop;
done:
    if(status)
        s3io_close(nciop,0);
    return status;
}

/* 
 *  Get file size in bytes.
 */
static int
s3io_filesize(ncio* nciop, off_t* filesizep)
{
    NCS3IO* s3io;
    if(nciop == NULL || nciop->pvt == NULL) return NC_EINVAL;
    s3io = (NCS3IO*)nciop->pvt;
    if(filesizep != NULL) *filesizep = s3io->size;
    return NC_NOERR;
}

/*
 *  Sync any changes to disk, then truncate or extend file so its size
 *  is length.  This is only intended to be called before close, if the
 *  file is open for writing and the actual size does not match the
 *  calculated size, perhaps as the result of having been previously
 *  written in NOFILL mode.
 */
static int
s3io_pad_length(ncio* nciop, off_t length)
{
    return NC_NOERR; /* do nothing */
}

/* Write out any dirty buffers to disk and
   ensure that next read will get data from disk.
   Sync any changes, then close the open file associated with the ncio
   struct, and free its memory.
   nciop - pointer to ncio to close.
   doUnlink - if true, unlink file
*/

static int 
s3io_close(ncio* nciop, int doUnlink)
{
    int status = NC_NOERR;
    NCS3IO* s3io;
    if(nciop == NULL || nciop->pvt == NULL) return NC_NOERR;

    s3io = (NCS3IO*)nciop->pvt;
    assert(s3io != NULL);

    status = nc_s3_close(s3io->curl);

    /* do cleanup  */
    if(s3io != NULL) {
	ncbytesfree(s3io->region);
	free(s3io);
    }
    if(nciop->path != NULL) free((char*)nciop->path);
    free(nciop);
    return status;
}

/*
 * Request that the region (offset, extent)
 * be made available through *vpp.
 */
static int
s3io_get(ncio* const nciop, off_t offset, size_t extent, int rflags, void** const vpp)
{
    int status = NC_NOERR;
    NCS3IO* s3io;

    if(nciop == NULL || nciop->pvt == NULL) {status = NC_EINVAL; goto done;}
    s3io = (NCS3IO*)nciop->pvt;

    assert(s3io->region == NULL);
    s3io->region = ncbytesnew();
    ncbytessetalloc(s3io->region,(unsigned long)extent);
    if((status = nc_s3_read(s3io->curl,nciop->path,offset,extent,s3io->region)))
	goto done;
    assert(ncbyteslength(s3io->region) == extent);
    if(vpp) *vpp = ncbytescontents(s3io->region);
done:
    return status;
}

/*
 * Like memmove(), safely move possibly overlapping data.
 */
static int
s3io_move(ncio* const nciop, off_t to, off_t from, size_t nbytes, int ignored)
{
    return NC_EPERM;
}

static int
s3io_rel(ncio* const nciop, off_t offset, int rflags)
{
    int status = NC_NOERR;
    NCS3IO* s3io;

    if(nciop == NULL || nciop->pvt == NULL) {status = NC_EINVAL; goto done;}
    s3io = (NCS3IO*)nciop->pvt;
    ncbytesfree(s3io->region);
    s3io->region = NULL;
done:
    return status;
}

/*
 * Write out any dirty buffers to disk and
 * ensure that next read will get data from disk.
 */
static int
s3io_sync(ncio* const nciop)
{
    return NC_NOERR; /* do nothing */
}
