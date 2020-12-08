inherit autotools qcommon

DESCRIPTION = "Location client api hdr"
PR = "r1"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/client_api/inc/"
S = "${WORKDIR}/qcom-opensource/location/client_api/inc/"
FILES_${PN} += "/usr/*"
PACKAGES = "${PN}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}
