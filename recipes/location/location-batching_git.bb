inherit autotools-brokensep pkgconfig useradd
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS FLP Batching"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/batching/"
S = "${WORKDIR}/hardware/qcom/gps/batching"

DEPENDS = "liblog qcom-gps-utils loc-core"
EXTRA_OECONF = "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-glib"

FILES:${PN} = "${libdir}/* ${includedir}/* ${sysconfdir}"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

#batching.conf path
SRC_URI += "file://hardware/qcom/gps/etc/"

do_install:append() {
    #Install default batching.conf file
    install -m 0444 -D ${WORKDIR}/hardware/qcom/gps/etc/batching.conf ${D}${sysconfdir}/batching.conf
    # batching.conf ownership with gps:gps
    chown gps:gps ${D}${sysconfdir}/batching.conf
}
