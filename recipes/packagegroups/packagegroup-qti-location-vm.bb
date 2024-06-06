SUMMARY = "QTI package group for Location modules on VMs"
LICENSE = "BSD-3-Clause"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-qti-location-vm \
    "

RDEPENDS:${PN} += "\
    qcom-gps-utils \
    loc-socket \
    location-client-api \
    location-integration-api \
    location-client-api-testapp \
    "

