inherit autotools qcommon
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "location client api test application"
PR = "r1"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/client_api_testapp/"
S = "${WORKDIR}/qcom-opensource/location/client_api_testapp"

DEPENDS = "location-client-api location-integration-api location-hal-daemon gps-utils"
EXTRA_OECONF += "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"
