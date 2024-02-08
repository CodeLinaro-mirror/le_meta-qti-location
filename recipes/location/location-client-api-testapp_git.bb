inherit autotools pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "location client api test application "
PR = "r1"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/client_api_testapp/"
S = "${WORKDIR}/qcom-opensource/location/client_api_testapp"

DEPENDS = "location-client-api location-integration-api qcom-gps-utils"

## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

FILES:${PN} += "${libdir}/*"
FILES:${PN} += "/usr/include/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-deps"

PACKAGECONFIG:remove = "loc-automotive"

