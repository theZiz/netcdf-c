/**
 * @file
 *
 * Read a range of data from an S3 object
 *
 * Copyright 2018 University Corporation for Atmospheric
 * Research/Unidata. See COPYRIGHT file for more info.
*/

#include "config.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#ifdef HAVE_UNISTD_H
#include <unistd.h>
#endif

#define CURL_DISABLE_TYPECHECK 1
#include <curl/curl.h>

#include "netcdf.h"
#include "nclog.h"
#include "ncbytes.h"
#include "nclist.h"
#include "ncs3.h"

#undef TRACE

#define CURLERR(e) (e)

/* Mnemonics */
#define GETCMD 0
#define HEADCMD 1

/* Forward */
static int setupconn(CURL* curl, const char* objecturl, NCbytes* buf);
static int execute(CURL* curl, int headcmd, long* httpcodep);
static int headerson(CURL* curl, NClist* list);
static void headersoff(CURL* curl);

#ifdef TRACE
static void
s3flush() {
fflush(stderr);
fflush(stdout);
}

static void
Trace(const char* fcn)
{
    fprintf(stdout,"xxx: %s\n",fcn);
    s3flush();
}
#else
#define s3flush()
#define Trace(fcn)
#endif /*TRACE*/

/**************************************************/

/**
@param objecturl url we propose to access
@param curlp curl handle stored here if non-NULL
@param filelenp store length of the file here if non-NULL
*/

int
nc_s3_open(const char* objecturl, void** curlp, long long* filelenp)
{
    int stat = NC_NOERR;
    CURL* curl = NULL;
    int i;
    NClist* list = NULL; 

    Trace("open");

    /* initialize curl*/
    curl = curl_easy_init();
    if (curl == NULL) stat = NC_ECURL;
    if(curlp && curl) *curlp = (void*)curl;
    if(filelenp) {
	*filelenp = -1;
        /* Attempt to get the file length using HEAD */
	list = nclistnew();
	if((stat = setupconn(curl,objecturl,NULL))) goto done;
	if((stat = headerson(curl,list))) goto done;
	if((stat = execute(curl,HEADCMD,NULL))) goto done;
	headersoff(curl);
	for(i=0;i<nclistlength(list);i+=2) {
	    char* s = nclistget(list,i);
	    if(strcasecmp(s,"content-length")==0) {
	        s = nclistget(list,i+1);
		sscanf(s,"%lld",filelenp);
		break;
	    }
	}
    }  
done:
    if(list) nclistfreeall(list);
s3flush();
    return stat;
}

int
nc_s3_close(void* curl0)
{
    int stat = NC_NOERR;
    CURL* curl = curl0;

    Trace("close");

    if(curl != NULL)
	(void)curl_easy_cleanup(curl);
s3flush();
    return stat;
}

/**
Assume URL etc has already been set.
@param curl curl handle
@param start starting offset
@param count number of bytes to read
@param buf store read data here -- caller must allocate and free
*/

int
nc_s3_read(CURL* curl, const char* objecturl, fileoffset_t start, fileoffset_t count, NCbytes* buf)
{
    int stat = NC_NOERR;
    char range[64];
    long httpcode = 200;
    CURLcode cstat = CURLE_OK;

    Trace("read");

    if(count == 0)
	goto done; /* do not attempt to read */

    if((stat = setupconn(curl,objecturl,buf)))
	goto fail;

    /* Set to read byte range */
    snprintf(range,sizeof(range),"%ld-%ld",(long)start,(long)((start+count)-1));
    cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_RANGE, range));
    if(cstat != CURLE_OK)
        {stat = NC_ECURL; goto done;}

    if((stat = execute(curl,GETCMD,&httpcode)))
	goto done;

done:
s3flush();
    return stat;

fail:
    stat = NC_ECURL;
    goto done;
}

static size_t
WriteMemoryCallback(void *ptr, size_t size, size_t nmemb, void *data)
{
    NCbytes* buf = data;
    size_t realsize = size * nmemb;

    Trace("WriteMemoryCallback");
    if(realsize == 0)
        nclog(NCLOGWARN,"WriteMemoryCallback: zero sized chunk");
    ncbytesappendn(buf, ptr, realsize);
    return realsize;
}

static size_t
HeaderCallback(char *buffer, size_t size, size_t nitems, void *data)
{
    NClist* list = data;
    size_t realsize = size * nitems;
    char* name;
    char* value;
    char* p;
    size_t i;
    int havecolon;

    Trace("HeaderCallback");
    if(realsize == 0)
        nclog(NCLOGWARN,"HeaderCallback: zero sized chunk");
    i = 0;
    for(p=buffer;(i < realsize) && (*p != ':');p++,i++);
    havecolon = (i < realsize);
    name = malloc(i+1);
    memcpy(name,buffer,i);
    name[i+1] = '\0';
    value = NULL;
    if(havecolon) {
	size_t vlen = (realsize - i);
        value = malloc(vlen+1);
	p++; /* skip colon */
        memcpy(value,p,vlen);
        value[vlen+1] = '\0';
    }
    nclistpush(list,name);
    nclistpush(list,value);
    return realsize;    
}

static int
setupconn(CURL* curl, const char* objecturl, NCbytes* buf)
{
    int stat = NC_NOERR;
    CURLcode cstat = CURLE_OK;

    if(objecturl != NULL) {
        /* Set the URL */
        cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_URL, (void*)objecturl));
        if (cstat != CURLE_OK) goto fail;
    }
    /* Set options */
    cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_TIMEOUT, 100)); /* 30sec timeout*/
    if (cstat != CURLE_OK) goto fail;
    cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_CONNECTTIMEOUT, 100));
    if (cstat != CURLE_OK) goto fail;
    cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_NOPROGRESS, 1));
    if (cstat != CURLE_OK) goto fail;

    if(buf != NULL) {
	/* send all data to this function  */
        cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, WriteMemoryCallback));
        if (cstat != CURLE_OK) goto fail;
        /* Set argument for WriteMemoryCallback */
        cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_WRITEDATA, (void*)buf));
        if (cstat != CURLE_OK) goto fail;
    } else {/* turn off data capture */
        (void)CURLERR(curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, NULL));
        (void)CURLERR(curl_easy_setopt(curl, CURLOPT_WRITEDATA, NULL));
    }
    /* Turn off header capture */
    headersoff(curl);

done:
    return stat;
fail:
    stat = NC_ECURL;
    goto done;
}

static int
execute(CURL* curl, int headcmd, long* httpcodep)
{
    int stat = NC_NOERR;
    CURLcode cstat = CURLE_OK;
    long httpcode = 0;

    if(headcmd) {
        cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_NOBODY, 1L));
        if(cstat != CURLE_OK) goto fail;
    }

    cstat = CURLERR(curl_easy_perform(curl));
    if(cstat != CURLE_OK) goto fail;

    cstat = CURLERR(curl_easy_getinfo(curl,CURLINFO_RESPONSE_CODE,&httpcode));
    if(cstat != CURLE_OK) httpcode = 0;
    if(httpcodep) *httpcodep = httpcode;

    if(headcmd) {
        cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_NOBODY, 0L));
        if(cstat != CURLE_OK) goto fail;
    }

done:
    return stat;
fail:
    stat = NC_ECURL;
    goto done;
}

static int
headerson(CURL* curl, NClist* list)
{
    int stat = NC_NOERR;
    CURLcode cstat = CURLE_OK;

    cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_HEADERFUNCTION, HeaderCallback));
    if(cstat != CURLE_OK) goto fail;
    cstat = CURLERR(curl_easy_setopt(curl, CURLOPT_HEADERDATA, (void*)list));
    if (cstat != CURLE_OK) goto fail;

done:
    return stat;
fail:
    stat = NC_ECURL;
    goto done;
}

static void
headersoff(CURL* curl)
{
    (void)CURLERR(curl_easy_setopt(curl, CURLOPT_HEADERFUNCTION, NULL));
    (void)CURLERR(curl_easy_setopt(curl, CURLOPT_HEADERDATA, NULL));
}

#ifdef IGNORE
static void
reset(CURL* curl)
{
    (void)curl_easy_reset(curl);
}
#endif
