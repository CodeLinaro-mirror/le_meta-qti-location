inherit autotools-brokensep pkgconfig
require ${COREBASE}/meta-qti-location/recipes/include/common-location-defines.inc
require ${COREBASE}/meta-qti-location/recipes/include/location-license-bsd3-clause.inc

DESCRIPTION = "ntrip client integration api test library"
PR = "r1"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

PACKAGE_ARCH ?= "${MACHINE_ARCH}"

SRC_URI = "file://qcom-opensource/location/ntrip-client-integration-api/"
S = "${WORKDIR}/qcom-opensource/location/ntrip-client-integration-api/"

DEPENDS = "gps-utils ntrip-client-integration-api-hdr"
EXTRA_OECONF = "--with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"
