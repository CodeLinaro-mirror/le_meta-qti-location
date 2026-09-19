inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "location client api library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/client_api/"
S = "${UNPACKDIR}/qcom-opensource/location/client_api"

DEPENDS = "glib-2.0 loc-pla-hdr libcutils qcom-gps-utils location-api-msg-proto"

## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

PACKAGECONFIG:remove = "loc-automotive"

SOLIBS=".so"
FILES_SOLIBSDEV=""
FILES:${PN} = "${libdir}/*"
INSANE_SKIP:${PN} = "dev-so"
