inherit autotools-brokensep pkgconfig linux-kernel-base
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "location qsocket library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/utils/loc_socket/"
S = "${WORKDIR}/qcom-opensource/location/utils/loc_socket"

DEPENDS = "virtual/kernel glib-2.0 loc-pla-hdr libcutils gps-utils"

## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

# additional configuration in loc-socket_git.bbappend

FILES:${PN} += "${libdir}/*"
FILES:${PN} += "/usr/include/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

