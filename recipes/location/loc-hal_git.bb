inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Loc HAL"
PR = "r5"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/"
S = "${WORKDIR}/hardware/qcom/gps"

PACKAGECONFIG[loc-automotive] = "--with-auto_feature"
PACKAGECONFIG:append = "${@bb.utils.filter('DISTRO_FEATURES', 'qti-telux', d)}"
PACKAGECONFIG[qti-telux] = "--with-telsdk,--without-telsdk"
DEPENDS = "loc-core libxml2 loc-base-util"

FILES:${PN} = "${libdir}/* ${sysconfdir}"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

