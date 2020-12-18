inherit autotools-brokensep pkgconfig
#require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "Nlp api hdr"
PR = "r1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/nlp_api/inc"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/nlp_api/inc"
S = "${WORKDIR}/qcom-opensource/location/nlp_api/inc"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}
