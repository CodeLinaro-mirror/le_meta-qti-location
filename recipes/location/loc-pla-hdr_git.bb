inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "GPS Loc Platform Library Abstraction"
PR = "r1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/pla/oe/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/pla/oe/"
S = "${WORKDIR}/hardware/qcom/gps/pla/oe"

DEPENDS += "libcutils liblog"

def target_in_list(list, prependstr, truestr, falsestr, d):
    print("target_in_list")
    target_set = set(d.getVar('BASEMACHINE', True).split())
    print(target_set)
    check_set = set(list.split())
    print(check_set)
    if target_set & check_set:
        return prependstr+truestr
    else:
        return prependstr+falsestr

DEPENDS += "${@target_in_list('sdx20 mdm9650 apq8017 apq8009', '', '', 'libutils', d)}"

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
