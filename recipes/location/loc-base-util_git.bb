inherit autotools-brokensep pkgconfig qprebuilt
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "LOC base utils"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/utils/base_util/"
S = "${WORKDIR}/qcom-opensource/location/utils/base_util"

DEPENDS = "glib-2.0 openssl sqlite3 loc-pla-hdr qcom-gps-utils"

do_install:append() {
    if [ -d "${D}/usr/include/loc-base-util" ]; then
        cp -R ${D}/usr/include/loc-base-util ${D}/usr/include/base_util
    fi
}

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
