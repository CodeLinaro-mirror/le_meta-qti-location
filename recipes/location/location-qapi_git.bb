inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "location qapi library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/qapi/"
S = "${WORKDIR}/qcom-opensource/location/qapi"

DEPENDS = "location-client-api"

FILES_${PN} = "${libdir}/* ${sysconfdir} ${includedir}/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} = "dev-so"

do_install_append() {
    install -m 0644 -D ${S}/etc/qapi.conf ${D}${sysconfdir}/qapi.conf
}
