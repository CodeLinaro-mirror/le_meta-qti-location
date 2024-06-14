inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "Loc API"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/loc_api/loc_api_v02/"
S = "${WORKDIR}/qcom-opensource/location/loc_api/loc_api_v02"

DEPENDS = "loc-core qmi-framework"

PACKAGECONFIG:append:sa525m = " ptp"
PACKAGECONFIG[ptp] = "--enable-ptp=yes, --enable-ptp=no, open-avb"

RDEPENDS_${PN} = "${@oe.utils.conditional('BASEMACHINE', 'sa525m', 'open-avb', '', d)}"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
