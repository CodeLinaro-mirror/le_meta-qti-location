inherit autotools-brokensep qcommon pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "GPS Loc HAL"
PR = "r5"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/"
S = "${WORKDIR}/hardware/qcom/gps"

DEPENDS = "loc-core loc-flp-hdr"
EXTRA_OECONF = "--with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"

CPPFLAGS += "-I${WORKSPACE}/base/include"

PACKAGES = "${PN}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir}/* ${sysconfdir}"
INSANE_SKIP_${PN} = "dev-so"

SRC_URI +="file://overlay/"
do_install_append() {
   #Install overlay conf file for target,if exists
   gpsConfOverlayFile='${WORKDIR}/overlay/${MACHINE}/etc/gps.conf'
   if [ -e ${gpsConfOverlayFile} ]; then
       echo "Installing gps.conf overlay file: ${gpsConfOverlayFile}"
       install -m 0644 -D "${gpsConfOverlayFile}" ${D}${sysconfdir}/gps.conf
   else
       install -m 0644 -D ${S}/etc/gps.conf ${D}${sysconfdir}/gps.conf
   fi
}
