inherit autotools-brokensep pkgconfig
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "ntrip client integration api test library"
PR = "r1"

PACKAGE_ARCH ?= "${MACHINE_ARCH}"

SRC_URI = "file://qcom-opensource/location/ntrip-client-integration-api/"
S = "${UNPACKDIR}/qcom-opensource/location/ntrip-client-integration-api"

DEPENDS = "qcom-gps-utils ntrip-client-integration-api-hdr"
