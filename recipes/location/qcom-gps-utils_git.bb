inherit autotools-brokensep pkgconfig useradd
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Utils"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/utils/"
S = "${UNPACKDIR}/hardware/qcom/gps/utils"

## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

DEPENDS = "glib-2.0 libcutils loc-pla-hdr location-api-iface"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

SRC_URI +="file://confappend/"
do_install:append() {
    #Install default gps.conf file
    install -m 0644 -D ${WORKSPACE}/hardware/qcom/gps/etc/gps.conf ${D}${sysconfdir}/gps.conf
    # Auto specific changes for gps.conf
    if ${@bb.utils.contains('PACKAGECONFIG', 'loc-automotive', 'true', 'false', d)}; then
        # Change default DEBUG_LEVEL to 1
        sed -i 's/DEBUG_LEVEL = 3/DEBUG_LEVEL = 1/' \
                ${D}${sysconfdir}/gps.conf
        # Append target specific confs
       gpsConfAppendFile='${UNPACKDIR}/confappend/auto/etc/gps.conf_append'
       if [ -e ${gpsConfAppendFile} ]; then
           echo "Appending file: ${gpsConfAppendFile} to gps.conf"
           cat ${gpsConfAppendFile} >> ${D}${sysconfdir}/gps.conf
       fi
    fi
    ## Ownership to gps:gps for gps.conf
    chown gps:gps ${D}${sysconfdir}/gps.conf
}

PACKAGECONFIG:remove = "loc-automotive loc-sa535m"
