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

DEPENDS = "loc-core"
EXTRA_OECONF = "--with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"

CPPFLAGS += "-I${WORKSPACE}/base/include"

PACKAGES = "${PN}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir}/* ${sysconfdir}"
INSANE_SKIP_${PN} = "dev-so"

SRC_URI +="file://confappend/"
do_install_append() {
    #Install default gps.conf file
    install -m 0644 -D ${S}/etc/gps.conf ${D}${sysconfdir}/gps.conf
    # Auto specific changes for gps.conf
    if ${@oe.utils.conditional('DISTRO', 'auto', 'true', 'false', d)}; then
        # Change default DEBUG_LEVEL to 1
        sed -i 's/DEBUG_LEVEL = 3/DEBUG_LEVEL = 1/' \
                ${D}${sysconfdir}/gps.conf
        # Enable DR Sync pulse
        sed -i 's/DR_SYNC_ENABLED = 0/DR_SYNC_ENABLED = 1/' \
                ${D}${sysconfdir}/gps.conf
        # Append target specific confs
       gpsConfAppendFile='${WORKDIR}/confappend/auto/etc/gps.conf_append'
       if [ -e ${gpsConfAppendFile} ]; then
           echo "Appending file: ${gpsConfAppendFile} to gps.conf"
           cat ${gpsConfAppendFile} >> ${D}${sysconfdir}/gps.conf
       fi
    fi
}
