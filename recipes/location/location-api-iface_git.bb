inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "location api interface"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/location/"
S = "${WORKDIR}/hardware/qcom/gps/location"

PACKAGES = "${PN}"
FILES:${PN} += "/usr/*"
FILES:${PN} += "/usr/include/*"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}
