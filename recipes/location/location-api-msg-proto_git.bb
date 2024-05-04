inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "location api msg protobuf library"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/location_api_msg_proto/"
S = "${WORKDIR}/qcom-opensource/location/location_api_msg_proto"

DEPENDS = "glib-2.0 protobuf protobuf-native loc-pla-hdr gps-utils"

## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

FILES:${PN} += "${libdir}/*"

do_compile:prepend () {
    echo "Running location_api_msg_protobuf_gen.sh"
    cd ${S}
    ./location_api_msg_protobuf_gen.sh
    cd -
}

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
