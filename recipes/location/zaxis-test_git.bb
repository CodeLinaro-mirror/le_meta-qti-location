inherit autotools-brokensep pkgconfig qprebuilt
require include/common-location-defines.inc
require include/location-license-bsd3-clause.inc

DESCRIPTION = "zaxis test app"
PR = "r1"

SRC_URI = "file://qcom-opensource/location/zaxis-test"
S = "${WORKDIR}/qcom-opensource/location/zaxis-test"
DEPENDS = "glib-2.0 qcom-gps-utils izat-client-api nlp-api-hdr loc-mq-client"
EXTRA_OECONF = "--with-nlpapi-includes=${STAGING_INCDIR}/nlp-api-hdr \
                --with-glib"
