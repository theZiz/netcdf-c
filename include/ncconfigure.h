/*
 * Copyright 2010 University Corporation for Atmospheric
 * Research/Unidata. See COPYRIGHT file for more info.
 *
 * This header file is for the parallel I/O functions of netCDF.
 *
 */
/* "$Id: netcdf_par.h,v 1.1 2010/06/01 15:46:49 ed Exp $" */

#ifndef NCCONFIGURE_H
#define NCCONFIGURE_H 1

#ifdef HAVE_STDLIB_H
#include <stdlib.h>
#endif

/*
This is included in bottom
of config.h. It is where, 
typically, alternatives to
missing functions should be
defined and missing types defined.
*/

/*
#ifndef HAVE_SSIZE_T
typedef long ssize_t;
#define HAVE_SSIZE_T
#endif
*/

#ifdef _MSC_VER
#ifndef HAVE_SSIZE_T
#include <basetsd.h>
typedef SSIZE_T ssize_t;
#define HAVE_SSIZE_T 1
#endif
#endif

/*Warning: Cygwin with -ansi does not define these functions
  in its headers.*/
#if __STDC__ == 1 /*supposed to be same as -ansi flag */
EXTERNL char* strdup(const char*);
EXTERNL size_t strlcat(const char*,const char*,size_t);
EXTERNL int snprintf(char*, size_t, const char*, ...); 
EXTERNL int strcasecmp(const char*, const char*);
EXTERNL long long int strtoll(const char*, char**, int);
EXTERNL unsigned long long int strtoull(const char*, char**, int);
EXTERNL int fileno(struct FILE*); 
#ifndef isascii
EXTERNL int isascii(int c);
#endif
#endif

#ifdef _WIN32
/* Windows strlcat_s is equivalent to strlcat, but different arg order */
#define strlcat(d,s,n) strcat_s((d),(n),(s))
#endif

/* handle null arguments */
#ifndef nulldup
#define nulldup(s) ((s)==NULL?NULL:strdup(s))
#endif
#ifndef nulllen
#define nulllen(s) ((s)==NULL?0:strlen(s))
#endif
#ifndef nullfree
#define nullfree(s) {if((s)!=NULL) {free(s);} else {}}
#endif

#ifndef HAVE_UCHAR
typedef unsigned char uchar;
#endif

#ifndef HAVE_LONGLONG
typedef long long longlong;
typedef unsigned long long ulonglong;
#endif

#ifndef HAVE_USHORT
typedef unsigned short ushort;
#endif

#ifndef HAVE_UINT
typedef unsigned int uint;
#endif

#endif /* NCCONFIGURE_H */
