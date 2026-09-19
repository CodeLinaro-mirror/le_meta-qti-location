inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "location qapi library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/qapi/"
S = "${UNPACKDIR}/qcom-opensource/location/qapi"

DEPENDS = "location-client-api"

FILES:${PN} = "${libdir}/* ${sysconfdir} ${includedir}/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

do_install:append() {
    install -m 0444 -D ${S}/etc/qapi.conf ${D}${sysconfdir}/qapi.conf
}
