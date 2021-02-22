inherit autotools-brokensep qcommon pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "Loc Core"
PR = "r1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/core/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/core/"
S = "${WORKDIR}/hardware/qcom/gps/core"

DEPENDS = "gps-utils"

EXTRA_OECONF += "${@oe.utils.conditional('DISTRO', 'auto', '--with-auto_feature', '', d)}"
