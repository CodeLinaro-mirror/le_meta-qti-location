inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "GPS Geofence"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/geofence/"
S = "${WORKDIR}/hardware/qcom/gps/geofence"


DEPENDS = "lbs-core"

CXXINC  = "-I${STAGING_INCDIR}/c++"
CXXINC += "-I${STAGING_INCDIR}/c++/${TARGET_SYS}"
CXXFLAGS ="${CXXINC}"

EXTRA_OECONF = "--with-glib"

PR = "r1"

LDFLAGS += "-Wl,--build-id=sha1"

PACKAGES = "${PN}"
FILES_${PN} = "${libdir}/*"
FILES_${PN} += "/usr/include/*"
# The geofence package contains symlinks that trip up insane
INSANE_SKIP_${PN} = "dev-so"
