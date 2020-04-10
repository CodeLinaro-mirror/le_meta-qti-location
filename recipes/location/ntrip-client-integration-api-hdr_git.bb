inherit autotools qcommon qlicense qprebuilt

DESCRIPTION = "Ntrip client integration api hdr"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/ntrip-client-integration-api/"
S = "${WORKDIR}/qcom-opensource/location/ntrip-client-integration-api/"
FILES_${PN} += "/usr/*"
PACKAGES = "${PN}"

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/*.h ${D}${includedir}
}
