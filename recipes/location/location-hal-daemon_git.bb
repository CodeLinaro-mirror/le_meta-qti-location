inherit autotools update-rc.d pkgconfig systemd
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "location hal daemon service"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/location_hal_daemon/"
S = "${WORKDIR}/qcom-opensource/location/location_hal_daemon"

DEPENDS = "loc-pla-hdr loc-hal gps-utils location-api-iface location-api location-api-msg-proto"

EXTRA_OECONF += "--with-locationapi-includes=${STAGING_INCDIR}/location-api-iface"

# location-hal-daemon_git.bbappend has additional configs
EXTRA_OECONF += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '--with-systemd', '', d)}"
EXTRA_OECONF += "${@oe.utils.conditional('DISTRO', 'auto', '--with-auto_feature', '', d)}"

INITSCRIPT_NAME = "location_hal_initializer"
INITSCRIPT_PARAMS = "start 98 2 3 4 5 . stop 2 0 1 6 ."

SRC_URI +="file://location_hal_daemon.service"
SRC_URI +="file://location_hal_daemon-tmpfilesd.conf"

PACKAGES = "${PN}"
FILES_${PN} += "${libdir}/*"
FILES_${PN} += "/usr/include/*"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP_${PN} = "dev-deps"

do_install_append () {

    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        ## Install systemd-tmpfiles config file
        install -d ${D}${sysconfdir}/tmpfiles.d/
        install -m 0644 ${WORKDIR}/location_hal_daemon-tmpfilesd.conf ${D}${sysconfdir}/tmpfiles.d/${BPN}.conf

        ## Install systemd service unit file
        install -d ${D}${sysconfdir}/systemd/system/
        install -m 0644 ${WORKDIR}/location_hal_daemon.service -D ${D}${sysconfdir}/systemd/system/location_hal_daemon.service

        if ${@bb.utils.contains_any('DISTRO_NAME', 'auto', 'true', 'false', d)}; then
          ## Add powermgr also to supplementary groups if POWERMANAGER is enabled
          if ${@oe.utils.conditional('BASEMACHINE', 'mdm9607', 'true', 'false', d)}; then
              sed -i 's/SupplementaryGroups=diag /SupplementaryGroups=diag powermgr /' \
                      ${D}${sysconfdir}/systemd/system/location_hal_daemon.service
          fi
          ## Add powermgr and vnw also to supplementary groups
          if ${@oe.utils.conditional('BASEMACHINE', 'sdxpoorwills', 'true', 'false', d)}; then
              sed -i 's/SupplementaryGroups=diag /SupplementaryGroups=diag powermgr vnw /' \
                      ${D}${sysconfdir}/systemd/system/location_hal_daemon.service
          fi
          if ${@oe.utils.conditional('BASEMACHINE', 'sdxprairie', 'true', 'false', d)}; then
              sed -i 's/SupplementaryGroups=diag /SupplementaryGroups=diag powermgr vnw /' \
                      ${D}${sysconfdir}/systemd/system/location_hal_daemon.service
          fi

          # Enable the service for sockets.target
          install -d ${D}${sysconfdir}/systemd/system/sockets.target.wants/
          ln -sf /etc/systemd/system/location_hal_daemon.service \
                    ${D}/etc/systemd/system/sockets.target.wants/location_hal_daemon.service
        else
          # Enable the service for multi-user.target
          install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
          ln -sf /etc/systemd/system/location_hal_daemon.service \
                    ${D}/etc/systemd/system/multi-user.target.wants/location_hal_daemon.service
        fi
    else
        install -m 0755 ${S}/location_hal_initializer -D ${D}${sysconfdir}/init.d/location_hal_initializer
    fi
}

