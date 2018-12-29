#!/bin/sh

if test "x$srcdir" = x ; then srcdir=`pwd`; fi
. ../test_common.sh

set -e

#Constants
URL3="https://s3-us-west-1.amazonaws.com/test-sample-netcdf/input.nc#mode=s3raw"
URL4="http://noaa-goes16.s3.amazonaws.com/ABI-L1b-RadC/2017/059/03/OR_ABI-L1b-RadC-M3C13_G16_s20170590337505_e20170590340289_c20170590340316.nc#mode=s3raw"

# See if netcdf-4 support is enabled
HAVENC4=`cat ${TOPSRCDIR}/libnetcdf.settings | sed -e '/NetCDF-4[ ]*API:[ 	]*yes/p' -e d`
if test "x$HAVENC4" = x ; then HAVENC4=no; else HAVENC4=yes; fi

rm -f tst_s3raw_nc3.cdl tst_s3raw_nc4.cdl 

echo ""

echo "*** Testing reading NetCDF-3 file with s3raw"
# Test using -k flag
K=`${NCDUMP} -k "$URL3"`
if test "x$K" != "x64-bit offset" ; then
   echo "test_s3raw: -k flag mismatch: expected=64-bit offset have=$K"
   exit 1
fi
# Now test the reading of at least the metadata
${NCDUMP} -h "$URL3" >tst_s3raw_nc3.cdl
# compare
diff tst_s3raw_nc3.cdl ref_tst_s3raw_nc3.cdl 

if test "x$HAVENC4" = xyes ; then
echo "*** Testing reading NetCDF-4 file with s3raw"
# Test using -k flag
K=`${NCDUMP} -k "$URL4"`
if test "x$K" != "xnetCDF-4" ; then
   echo "test_s3raw: -k flag mismatch: expected=netCDF-4 have=$K"
   exit 1
fi
# Now test the reading of at least the metadata
${NCDUMP} -h "$URL4" >tst_s3raw_nc4.cdl
# compare
diff tst_s3raw_nc4.cdl ref_tst_s3raw_nc4.cdl 
fi

exit
