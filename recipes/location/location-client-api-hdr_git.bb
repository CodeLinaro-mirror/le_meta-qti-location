inherit autotools
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "Location client api hdr"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/client_api/inc/"
S = "${UNPACKDIR}/qcom-opensource/location/client_api/inc"
FILES:${PN} += "/usr/*"
PACKAGES = "${PN}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}
