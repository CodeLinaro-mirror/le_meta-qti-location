inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc

DESCRIPTION = "location api msg protobuf library"
PR = "r1"
LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                   file://${COREBASE}/meta-qti-bsp/files/common-licenses/BSD-3-Clause-Clear;md5=15d96e54d2b28695491cb208edf6199d"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://qcom-opensource/location/location_api_msg_proto/"
S = "${WORKDIR}/qcom-opensource/location/location_api_msg_proto"

DEPENDS = "glib-2.0 protobuf protobuf-native loc-pla-hdr gps-utils"
EXTRA_OECONF = "--with-glib"

FILES_${PN} += "${libdir}/*"

do_compile_prepend () {
    echo "Running location_api_msg_protobuf_gen.sh"
    cd ${S}
    ./location_api_msg_protobuf_gen.sh
    cd -
}
