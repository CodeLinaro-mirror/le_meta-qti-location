inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "location qsocket library"
PR = "r1"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/utils/loc_socket/"
S = "${WORKDIR}/qcom-opensource/location/utils/loc_socket"

DEPENDS = "glib-2.0 loc-pla-hdr libcutils gps-utils qmi-framework"
EXTRA_OECONF = "--with-glib"

### check kernel version which supports qsocket vs qrtr
EXTRA_OECONF += "${@bb.utils.contains_any('PREFERRED_VERSION_linux-msm', '3.18 4.4 4.9', '--enable-kernel-qrtr=no', '--enable-kernel-qrtr=yes', d)}"

PACKAGES = "${PN}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} += "${libdir}/*"
FILES_${PN} += "/usr/include/*"
INSANE_SKIP_${PN} = "dev-so"

