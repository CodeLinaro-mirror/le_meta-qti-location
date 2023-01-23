inherit autotools-brokensep pkgconfig linux-kernel-base
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "location qsocket library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/utils/loc_socket/"
S = "${WORKDIR}/qcom-opensource/location/utils/loc_socket"

DEPENDS = "virtual/kernel glib-2.0 loc-pla-hdr libcutils gps-utils"

# additional configuration in loc-socket_git.bbappend

FILES_${PN} += "${libdir}/*"
FILES_${PN} += "/usr/include/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} = "dev-so"

