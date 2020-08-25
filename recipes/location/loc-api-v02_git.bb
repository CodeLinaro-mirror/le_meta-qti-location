inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "Loc API"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/loc_api/loc_api_v02/"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/loc_api/loc_api_v02/"
S = "${WORKDIR}/qcom-opensource/location/loc_api/loc_api_v02"

DEPENDS = "loc-core qmi-framework"
EXTRA_OECONF = "--with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-glib"

CPPFLAGS += "-I${WORKSPACE}/base/include"
