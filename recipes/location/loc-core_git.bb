inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "Loc Core"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/core/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/core/"
S = "${WORKDIR}/hardware/qcom/gps/core"

DEPENDS = "gps-utils"

PACKAGECONFIG:append:sa525m = " ptp"
PACKAGECONFIG[ptp] = "--enable-ptp=yes, --enable-ptp=no, open-avb"

RDEPENDS_${PN} = "${@oe.utils.conditional('BASEMACHINE', 'sa525m', 'open-avb', '', d)}"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
