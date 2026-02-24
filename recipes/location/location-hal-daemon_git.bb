inherit autotools update-rc.d pkgconfig systemd
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "location hal daemon service"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/location_hal_daemon/"
S = "${WORKDIR}/qcom-opensource/location/location_hal_daemon"

DEPENDS = "loc-pla-hdr loc-hal qcom-gps-utils location-api-iface location-api location-api-msg-proto"
RDEPENDS:${PN} = "loc-hal"

PACKAGECONFIG[loc-automotive] = "--with-auto_feature"

# location-hal-daemon_git.bbappend has additional configs
EXTRA_OECONF += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '--with-systemd', '', d)}"

INITSCRIPT_NAME = "location_hal_initializer"
INITSCRIPT_PARAMS = "start 98 2 3 4 5 . stop 2 0 1 6 ."

SRC_URI +="file://location_hal_daemon.service"
SRC_URI +="file://location_hal_daemon-tmpfilesd.conf"
SRC_URI +="file://location_hal_daemon_auto.conf"

FILES:${PN} += "${libdir}/*"
FILES:${PN} += "/usr/include/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-deps"

do_install:append () {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        ## Install systemd-tmpfiles config file
        install -d ${D}${sysconfdir}/tmpfiles.d/
        install -m 0644 ${WORKDIR}/location_hal_daemon-tmpfilesd.conf ${D}${sysconfdir}/tmpfiles.d/${BPN}.conf

        ## Install systemd service unit file
        install -d ${D}${sysconfdir}/systemd/system/
        install -m 0644 ${WORKDIR}/location_hal_daemon.service -D ${D}${sysconfdir}/systemd/system/location_hal_daemon.service

        if ${@bb.utils.contains('PACKAGECONFIG', 'loc-automotive', 'true', 'false', d)}; then
          ## Install auto specific drop-in file
          install -d ${D}${sysconfdir}/systemd/system/location_hal_daemon.service.d
          install -m 0644 ${WORKDIR}/location_hal_daemon_auto.conf \
                  ${D}${sysconfdir}/systemd/system/location_hal_daemon.service.d/location_hal_daemon_auto.conf

            ## Append 'dlt' group only when DLT logging is enabled
            if ${@bb.utils.contains("MACHINE_FEATURES", "dlt-logging", "true", "false", d)} \
                    && [ "${LOC_ENABLE_DLT}" = "1" ]; then
                sed -i 's/^\(SupplementaryGroups=.*\)/\1 dlt/' \
                    ${D}${sysconfdir}/systemd/system/location_hal_daemon.service.d/location_hal_daemon_auto.conf
            fi
        fi

        if ${@bb.utils.contains('PACKAGECONFIG', 'loc-bootkpi', 'true', 'false', d)}; then
            #Install service files to socket.targets only if dependent boot optmization changes are present.
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

