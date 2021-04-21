inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "location integration api library"
PR = "r1"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/integration_api/"
S = "${WORKDIR}/qcom-opensource/location/integration_api"

DEPENDS = "glib-2.0 loc-pla-hdr libcutils gps-utils location-hal-daemon-hdr location-client-api-hdr"
EXTRA_OECONF = "--with-glib"

SOLIBS=".so"
FILES_SOLIBSDEV=""
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir}/*"
INSANE_SKIP_${PN} = "dev-so"

