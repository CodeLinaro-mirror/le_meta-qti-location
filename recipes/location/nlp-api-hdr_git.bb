inherit autotools-brokensep pkgconfig
#require include/common-location-defines.inc

DESCRIPTION = "Nlp api hdr"
PR = "r1"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/nlp_api/inc/"
S = "${UNPACKDIR}/qcom-opensource/location/nlp_api/inc"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}
