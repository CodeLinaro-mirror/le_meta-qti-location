inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Loc Platform Library Abstraction"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/pla/oe/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/pla/oe/"
S = "${WORKDIR}/hardware/qcom/gps/pla/oe"

DEPENDS += "libutils libcutils liblog"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}

PACKAGES = "${PN}"
FILES_${PN} += "/usr/include/*"
