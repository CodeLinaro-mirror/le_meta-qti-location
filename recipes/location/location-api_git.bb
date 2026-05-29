inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "location api interface"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/location/"
S = "${UNPACKDIR}/hardware/qcom/gps/location"

DEPENDS = "qcom-gps-utils"

## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

PACKAGECONFIG:remove = "loc-automotive loc-sa535m"
