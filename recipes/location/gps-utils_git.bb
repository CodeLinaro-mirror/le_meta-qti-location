inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Utils"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/utils/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/utils/"
S = "${WORKDIR}/hardware/qcom/gps/utils"

DEPENDS = "glib-2.0 libcutils loc-pla-hdr location-api-iface"
EXTRA_OECONF = "--with-locationapi-includes=${STAGING_INCDIR}/location-api-iface \
                --with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} = "dev-so"
