inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "location client api library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/client_api/"
S = "${WORKDIR}/qcom-opensource/location/client_api"

DEPENDS = "glib-2.0 loc-pla-hdr libcutils gps-utils location-hal-daemon-hdr"
EXTRA_OECONF = "--with-glib"

SOLIBS=".so"
FILES_SOLIBSDEV=""
FILES_${PN} = "${libdir}/*"
INSANE_SKIP_${PN} = "dev-so"

