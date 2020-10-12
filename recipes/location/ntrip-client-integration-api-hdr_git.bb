inherit autotools
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "Ntrip client integration api hdr"
PR = "r1"

PACKAGE_ARCH ?= "${MACHINE_ARCH}"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/ntrip-client-integration-api/"
S = "${WORKDIR}/qcom-opensource/location/ntrip-client-integration-api"
FILES_${PN} += "/usr/*"
PACKAGES = "${PN}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}
