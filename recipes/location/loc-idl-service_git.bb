inherit cmake pkgconfig locationcommon

LICENSE = "BSD-3-Clause-Clear & MPL-2.0"
LIC_FILES_CHKSUM += "file://${COREBASE}/meta/files/common-licenses/\
BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"
LIC_FILES_CHKSUM += "file://${COMMON_LICENSE_DIR}/MPL-2.0;md5=815ca599c9df247a0c7f619bab123dad"

PACKAGECONFIG:sa525m:append = "loc-automotive "

# qcommon bbclass
# Common bitbake recipe information for QTI meta layers.
# Below are common values, statements and functions.
#

DESCRIPTION = "Location IDL service"
PR = "r1"

PACKAGE_ARCH    ?= "${MACHINE_ARCH}"
FILESPATH =+ "${WORKSPACE}:"

SRC_URI = "file://qcom-opensource/location/loc-fidl/"
S = "${UNPACKDIR}/qcom-opensource/location/loc-fidl"

CPPFLAGS += " -DUSE_ANDROID_LOGGING "
LDFLAGS += " -llog "
CFLAGS += "${@cflags_modem_disabled_target(d)} "
CPPFLAGS += "${@cflags_modem_disabled_target(d)} "

DEPENDS = " loc-hal location-api open-avb loc-diag-iface-hdr "
DEPENDS += "location-client-api location-integration-api common-api-c++ \
           vsomeip common-api-c++-someip "

DEPENDS += "${@bb.utils.contains('PACKAGECONFIG', 'loc-automotive', ' powermanager-lib ', '', d)}"
CPPFLAGS += "${@bb.utils.contains('PACKAGECONFIG', 'loc-automotive', ' -DPOWER_DAEMON_MGR_ENABLED ', ' ', d)}"

RDEPENDS:${PN} = "open-avb"

FILES:${PN} += "${libdir}/*"
FILES:${PN} += "/usr/include/*"
FILES:${PN} += "/usr/bin/*"
FILES:${PN} += "/usr/etc/*"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-deps"


EXTRA_OECMAKE = "-DCMAKE_INSTALL_PREFIX=/usr \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DINSTALL_CMAKE_DIR:PATH=${baselib}/cmake/CommonAPI \
    "
