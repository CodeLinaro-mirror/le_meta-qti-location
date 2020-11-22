inherit autotools pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "location client api test application "
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/client_api_testapp/"
S = "${WORKDIR}/qcom-opensource/location/client_api_testapp"

DEPENDS = "location-client-api location-integration-api location-hal-daemon gps-utils"

EXTRA_OECONF += "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"
