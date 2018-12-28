/* Copyright 2018-2018 University Corporation for Atmospheric
   Research/Unidata. */
/**
 * Header file for dmode.c
 * @author Dennis Heimbigner
 */

#ifndef NCS3_H
#define NCS3_H

/* Avoid use of off_t or off64_t */
typedef long long fileoffset_t;

extern int nc_s3_open(const char* objecturl, void** curlp, fileoffset_t* filelenp);
extern int nc_s3_read(void* curl, const char* url, fileoffset_t start, fileoffset_t count, NCbytes* buf);
extern int nc_s3_close(void* curl);

#endif /*NCS3_H*/
