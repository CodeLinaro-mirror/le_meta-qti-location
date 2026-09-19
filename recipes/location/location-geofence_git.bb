inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "GPS Geofence"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://hardware/qcom/gps/geofence/"
S = "${UNPACKDIR}/hardware/qcom/gps/geofence"


DEPENDS = "lbs-core"

CXXINC  = "-I${STAGING_INCDIR}/c++"
CXXINC += "-I${STAGING_INCDIR}/c++/${TARGET_SYS}"
CXXFLAGS ="${CXXINC} -O2"

EXTRA_OECONF = "--with-glib"

PR = "r1"

LDFLAGS += "-Wl,--build-id=sha1"

FILES:${PN} = "${libdir}/*"
FILES:${PN} += "/usr/include/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""

# The geofence package contains symlinks that trip up insane
INSANE_SKIP:${PN} = "dev-so"
