inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "Loc Core"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/core/"
S = "${UNPACKDIR}/hardware/qcom/gps/core"

PACKAGECONFIG[loc-automotive] = "--with-auto_feature"

## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

DEPENDS = "qcom-gps-utils"

PACKAGECONFIG:append:sa525m = " ptp"
PACKAGECONFIG[ptp] = "--enable-ptp=yes, --enable-ptp=no, open-avb"

PACKAGECONFIG:remove = "loc-sa535m"

RDEPENDS_${PN} = "${@oe.utils.conditional('BASEMACHINE', 'sa525m', 'open-avb', '', d)}"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so file-rdeps"
