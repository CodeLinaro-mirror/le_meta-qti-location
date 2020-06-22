inherit autotools qcommon qlicense qprebuilt
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "GPS FLP Batching"
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/batching/"
SRC_DIR = "${WORKSPACE}/hardware/qcom/gps/batching/"
S = "${WORKDIR}/hardware/qcom/gps/batching"

DEPENDS = "liblog gps-utils loc-core"
EXTRA_OECONF = "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-glib"

PACKAGES = "${PN}"
FILES_${PN} = "${libdir}/* ${sysconfdir}"
INSANE_SKIP_${PN} = "dev-so"
