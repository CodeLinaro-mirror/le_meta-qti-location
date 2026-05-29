inherit autotools-brokensep pkgconfig useradd
require include/common-location-defines.inc

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
LIC_FILES_CHKSUM += "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

DESCRIPTION = "location qsocket header library"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/utils/loc_socket/"
S = "${UNPACKDIR}/qcom-opensource/location/utils/loc_socket"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}

PACKAGES = "${PN}"
FILES:${PN} += "/usr/include/*"
