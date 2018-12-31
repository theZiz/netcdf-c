/* Copyright 2018-2018 University Corporation for Atmospheric
   Research/Unidata. */
/**
 * Header file for dhttp.c
 * @author Dennis Heimbigner
 */

#ifndef NCHTTP_H
#define NCHTTP_H

/* Avoid use of off_t or off64_t */
typedef long long fileoffset_t;

extern int nc_http_open(const char* objecturl, void** curlp, fileoffset_t* filelenp);
extern int nc_http_read(void* curl, const char* url, fileoffset_t start, fileoffset_t count, NCbytes* buf);
extern int nc_http_close(void* curl);

#endif /*NCHTTP_H*/
