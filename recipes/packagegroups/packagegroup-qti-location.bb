SUMMARY = "QTI package group for Location modules"
LICENSE = "BSD-3-Clause"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

LOC_IDL_SERVICE_ENABLEMENT ?= "False"
LOC_IDL_SERVICE_ENABLEMENT:sa525m = "True"
LOC_IDL_SERVICE_ENABLEMENT:sa510m = "False"


PACKAGES = "\
    ${@bb.utils.contains_any("MACHINE_FEATURES", "qti-location", "packagegroup-qti-location", "", d)} \
    "


# location packages which are common across various machines
RDEPENDS:${PN} += "\
    location-hal-daemon \
    location-client-api \
    loc-socket \
    location-client-api-testapp \
    location-integration-api \
    ${@oe.utils.conditional('LOC_IDL_SERVICE_ENABLEMENT', 'True', 'loc-idl-service', '', d)} \
    loc-base-util \
    "
