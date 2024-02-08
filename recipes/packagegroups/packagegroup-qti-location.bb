SUMMARY = "QTI package group for Location modules"
LICENSE = "BSD-3-Clause"

AUTOMOTIVE:TARGET ?= "False"
AUTOMOTIVE:TARGET:sa525m = "True"


PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

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
    ${@oe.utils.conditional('AUTOMOTIVE_TARGET', 'True', 'loc-idl-service', '', d)} \
    "
