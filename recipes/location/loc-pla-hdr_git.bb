inherit autotools-brokensep pkgconfig locationcommon
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Loc Platform Library Abstraction"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/pla/oe/"
S = "${UNPACKDIR}/hardware/qcom/gps/pla/oe"

DEPENDS += "libcutils liblog"

DEPENDS += "${@loc_target_in_list('sdx20 mdm9650 apq8017 apq8009 apq8053', '', '', 'libutils', d)}"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}

PACKAGES = "${PN}"
FILES:${PN} += "/usr/include/*"
