inherit autotools qcommon update-rc.d systemd
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "location hal daemon service"
PR = "r1"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/location_hal_daemon/"
S = "${WORKDIR}/qcom-opensource/location/location_hal_daemon"

DEPENDS = "loc-pla-hdr loc-hal location-service gps-utils location-api-iface location-api"

EXTRA_OECONF = "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-locationapi-includes=${STAGING_INCDIR}/location-api-iface \
                --with-glib"

DEPENDS += "${@oe.utils.conditional('BASEMACHINE', 'mdm9607', 'powermanager-lib', '', d)}"
DEPENDS += "${@oe.utils.conditional('BASEMACHINE', 'sdxpoorwills', 'powermanager-lib', '', d)}"
EXTRA_OECONF += "${@oe.utils.conditional('BASEMACHINE', 'mdm9607', '--enable-target-mdm9607=yes', '', d)}"
EXTRA_OECONF += "${@oe.utils.conditional('BASEMACHINE', 'sdxpoorwills', '--enable-target-sdxpoorwills=yes', '', d)}"
EXTRA_OECONF += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '--with-systemd', '', d)}"
EXTRA_OECONF += "${@oe.utils.conditional('DISTRO', 'auto', '--with-auto_feature', '', d)}"

INITSCRIPT_NAME = "location_hal_initializer"
INITSCRIPT_PARAMS = "start 98 2 3 4 5 . stop 2 0 1 6 ."

SRC_URI +="file://location_hal_daemon.service"
SRC_URI +="file://location_hal_daemon-tmpfilesd.conf"

PACKAGES = "${PN}"
FILES_${PN} += "${libdir}/*"
FILES_${PN} += "/usr/include/*"

INSANE_SKIP_${PN} = "dev-deps"

do_install_append () {

    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        ## Install systemd-tmpfiles config file
        install -d ${D}${sysconfdir}/tmpfiles.d/
        install -m 0644 ${WORKDIR}/location_hal_daemon-tmpfilesd.conf ${D}${sysconfdir}/tmpfiles.d/${BPN}.conf

        ## Install systemd service unit file
        install -d ${D}${sysconfdir}/systemd/system/
        install -m 0644 ${WORKDIR}/location_hal_daemon.service -D ${D}${sysconfdir}/systemd/system/location_hal_daemon.service

        ## Add powermgr also to supplementary groups if POWERMANAGER is enabled
        if ${@oe.utils.conditional('BASEMACHINE', 'mdm9607', 'true', 'false', d)}; then
            sed -i 's/SupplementaryGroups=diag /SupplementaryGroups=diag powermgr /' \
                    ${D}${sysconfdir}/systemd/system/location_hal_daemon.service
        fi
        if ${@oe.utils.conditional('BASEMACHINE', 'sdxpoorwills', 'true', 'false', d)}; then
            sed -i 's/SupplementaryGroups=diag /SupplementaryGroups=diag powermgr /' \
                    ${D}${sysconfdir}/systemd/system/location_hal_daemon.service
        fi
        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        ln -sf /etc/systemd/system/location_hal_daemon.service \
                          ${D}/etc/systemd/system/multi-user.target.wants/location_hal_daemon.service
    else
        install -m 0755 ${S}/location_hal_initializer -D ${D}${sysconfdir}/init.d/location_hal_initializer
    fi
}

