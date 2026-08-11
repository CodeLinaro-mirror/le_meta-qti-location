# Common defines applicable for all location BB files
inherit locationcommon

# qcommon bbclass
# Common bitbake recipe information for QTI meta layers.
# Below are common values, statements and functions.
#
FILESPATH        =+ "${WORKSPACE}:"
PACKAGE_ARCH    ?= "${MACHINE_ARCH}"

EXTRA_OECONF = "--with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"

# packageconfig for location automotive
## legacy LE Auto targets
PACKAGECONFIG ??= "${@oe.utils.conditional('DISTRO', 'auto', 'loc-automotive', '', d)}"
## PDK based LE Auto targets
PACKAGECONFIG:sa410m = "loc-automotive "
PACKAGECONFIG:sa515m = "loc-automotive loc-bootkpi "
PACKAGECONFIG:sa525m = "loc-automotive "

LOC_ENABLE_DLT ?= "1"
LOC_DLT_ENABLED = "${@ \
    'yes' if bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', True, False, d) \
           and d.getVar('LOC_ENABLE_DLT') == '1' \
    else 'no' \
}"
CFLAGS:append = "${@ ' -DLOC_USE_DLT ' if d.getVar('LOC_DLT_ENABLED') == 'yes' else ''}"
CPPFLAGS:append = "${@ ' -DLOC_USE_DLT ' if d.getVar('LOC_DLT_ENABLED') == 'yes' else ''}"
DEPENDS:append = "${@ ' dlt-daemon ' if d.getVar('LOC_DLT_ENABLED') == 'yes' else ''}"
LDFLAGS:append = "${@ ' -ldlt ' if d.getVar('LOC_DLT_ENABLED') == 'yes' else '' }"

LOC_ENABLE_CLOG ?= "1"

LOC_CLOG_ENABLED = "${@ \
    'yes' if bb.utils.contains('MACHINE_FEATURES', 'commonlog', True, False, d) \
           and d.getVar('LOC_ENABLE_CLOG') == '1' \
    else 'no' \
}"
CFLAGS:append = "${@ ' -DLOC_USE_CLOG ' if d.getVar('LOC_CLOG_ENABLED') == 'yes' else ''}"
CPPFLAGS:append = "${@ ' -DLOC_USE_CLOG ' if d.getVar('LOC_CLOG_ENABLED') == 'yes' else ''}"
DEPENDS:append = "${@ ' commonlog-lib' if d.getVar('LOC_CLOG_ENABLED') == 'yes' else ''}"
LDFLAGS:append = "${@ ' -lclog ' if d.getVar('LOC_CLOG_ENABLED') == 'yes' else '' }"


##Entries for VMs
PACKAGECONFIG:append = "${@bb.utils.contains('MACHINE_FEATURES', 'qti-vm-guest', 'loc-vm', '', d)}"

# enabling logcat for target which supports logd in both internal and external builds.
# link with liblog, this library will take care of directing to logcat if logd is enabled, else
# will redirect to default logging system.
CFLAGS:append = "${@loc_target_in_list('mdm9650', '', '', ' -DUSE_ANDROID_LOGGING ', d)}"
CPPFLAGS:append = "${@loc_target_in_list('mdm9650', '', '', ' -DUSE_ANDROID_LOGGING ', d)}"
LDFLAGS:append = "${@loc_target_in_list('mdm9650', '', '', ' -llog ', d)}"

# APQ targets having no modem
CFLAGS:append = "${@cflags_modem_disabled_target(d)} "
CPPFLAGS:append = "${@cflags_modem_disabled_target(d)} "

#Ubuntu Core SIs
CFLAGS:append = "${@loc_target_in_list('qcs6490', '', ' -DUBUNTU_BASE ', '  ', d)}"
CPPFLAGS:append = "${@loc_target_in_list('qcs6490', '', ' -DUBUNTU_BASE ', '  ', d)}"

# NHz enabled targets
CFLAGS:append:qcs6490 = " -DFEATURE_NHZ_ENABLED "
CPPFLAGS:append:qcs6490 = " -DFEATURE_NHZ_ENABLED "
