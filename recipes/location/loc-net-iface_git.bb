inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "GPS Loc Net Iface"
PR = "r5"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/loc_net_iface/"
SRC_DIR = "${WORKSPACE}/qcom-opensource/location/loc_net_iface/"
S = "${WORKDIR}/qcom-opensource/location/loc_net_iface"

DEPENDS = "data qmi qmi-framework loc-hal data-items"
EXTRA_OECONF = "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-glib"

def oe_conf_mobileap_indication_enabled(d):
    # Check if data mobileap has changes for register indication.
    # not available for sdm845 target
    if d.getVar('BASEMACHINE', True) == 'sdm845' or d.getVar('BASEMACHINE', True) == 'mdm9607':
        return "--enable-mobileap-indications=no"
    else:
        return "--enable-mobileap-indications=yes"

def oe_conf_roaming_backhaul_status_indication_enabled(d):
    # Check if data mobileap has changes for roaming and backhaul status indication.
    # not available for mdm9607 target
    if d.getVar('BASEMACHINE', True) == 'mdm9607':
        return "--enable-roaming-backhaul-status-indications=no"
    else:
        return "--enable-roaming-backhaul-status-indications=yes"

EXTRA_OECONF += "${@oe_conf_mobileap_indication_enabled(d)}"
EXTRA_OECONF += "${@oe_conf_roaming_backhaul_status_indication_enabled(d)}"

PACKAGES = "${PN}"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir}/*"
INSANE_SKIP_${PN} = "dev-so"
