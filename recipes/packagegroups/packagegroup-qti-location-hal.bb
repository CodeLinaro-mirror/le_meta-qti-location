SUMMARY = "QTI package group for Location modules"
LICENSE = "BSD-3-Clause"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-qti-location-hal \
    "


# location packages which are common across various machines
RDEPENDS_${PN} += "\
    location-hal-daemon \
    location-client-api \
    loc-socket \
    location-client-api-testapp \
    location-integration-api \
    "
