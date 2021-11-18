inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Geofence"

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
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
# The geofence package contains symlinks that trip up insane
INSANE_SKIP_${PN} = "dev-so"
