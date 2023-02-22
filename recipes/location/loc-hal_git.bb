inherit autotools-brokensep pkgconfig useradd
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Loc HAL"
PR = "r5"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/"
S = "${WORKDIR}/hardware/qcom/gps"

DEPENDS = "loc-core"

FILES:${PN} = "${libdir}/* ${sysconfdir}"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

SRC_URI +="file://confappend/"
do_install:append() {
    #Install default gps.conf file
    install -m 0644 -D ${S}/etc/gps.conf ${D}${sysconfdir}/gps.conf
    # Auto specific changes for gps.conf
    if ${@bb.utils.contains('PACKAGECONFIG', 'loc-automotive', 'true', 'false', d)}; then
        # Change default DEBUG_LEVEL to 1
        sed -i 's/DEBUG_LEVEL = 3/DEBUG_LEVEL = 1/' \
                ${D}${sysconfdir}/gps.conf
        # Append target specific confs
       gpsConfAppendFile='${WORKDIR}/confappend/auto/etc/gps.conf_append'
       if [ -e ${gpsConfAppendFile} ]; then
           echo "Appending file: ${gpsConfAppendFile} to gps.conf"
           cat ${gpsConfAppendFile} >> ${D}${sysconfdir}/gps.conf
       fi
    fi
    ## Ownership to gps:gps for gps.conf
    chown gps:gps ${D}${sysconfdir}/gps.conf
}
