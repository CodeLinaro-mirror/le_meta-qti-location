inherit autotools qcommon qlicense qprebuilt
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "location client api test application "
PR = "r1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/client_api_testapp/"
S = "${WORKDIR}/qcom-opensource/location/client_api_testapp"

DEPENDS = "glib-2.0 loc-pla-hdr libcutils gps-utils location-client-api location-hal-daemon"
EXTRA_OECONF ="--with-glib"

