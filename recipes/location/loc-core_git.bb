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

EXTRA_OECONF += "${@oe.utils.conditional('DISTRO', 'auto', '--with-auto_feature', '', d)}"
