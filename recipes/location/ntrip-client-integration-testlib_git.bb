inherit autotools-brokensep pkgconfig qcommon qlicense qprebuilt
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "ntrip client integration api test library"
PR = "r1"

SRC_URI = "file://qcom-opensource/location/ntrip-client-integration-api/"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/ntrip-client-integration-api/"
S = "${WORKDIR}/qcom-opensource/location/ntrip-client-integration-api/"

DEPENDS = "gps-utils ntrip-client-integration-api-hdr"
EXTRA_OECONF = "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"
