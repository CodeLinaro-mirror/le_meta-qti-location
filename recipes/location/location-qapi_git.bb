inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "location qapi library"
PR = "r1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/qapi/"
S = "${WORKDIR}/qcom-opensource/location/qapi"

DEPENDS = "location-client-api"
EXTRA_OECONF = "--with-glib"

PACKAGES = "${PN}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir}/* ${sysconfdir}"
INSANE_SKIP_${PN} = "dev-so"

do_install_append() {
    install -m 0644 -D ${WORKSPACE}/gps/etc/qapi.conf ${D}${sysconfdir}/qapi.conf
}
