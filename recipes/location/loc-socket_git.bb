inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "location qsocket library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/utils/loc_socket/"
S = "${WORKDIR}/qcom-opensource/location/utils/loc_socket"

DEPENDS = "glib-2.0 loc-pla-hdr libcutils gps-utils"
EXTRA_OECONF = "--with-glib"

# additional configuration in loc-socket_git.bbappend

PACKAGES = "${PN}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} += "${libdir}/*"
FILES_${PN} += "/usr/include/*"
INSANE_SKIP_${PN} = "dev-so"

