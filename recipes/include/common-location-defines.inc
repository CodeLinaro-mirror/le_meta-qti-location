# Common defines applicable for all location BB files
inherit locationcommon

# qcommon bbclass
# Common bitbake recipe information for QTI meta layers.
# Below are common values, statements and functions.
#
FILESPATH        =+ "${WORKSPACE}:"
WORKSPACE_CHECK = "${@d.getVar('WORKSPACE') or ""}"
SRC_URI          = "file://${@d.getVar('SRC_DIR', True).replace('${WORKSPACE_CHECK}/', '')}"
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
PACKAGECONFIG[loc-automotive] = "--with-auto_feature"

##Entries for VMs
PACKAGECONFIG:append = "${@bb.utils.contains('MACHINE_FEATURES', 'qti-vm-guest', 'loc-vm', '', d)}"
## Both VMs and EAPs will be treated in similar way
PACKAGECONFIG[loc-vm] = "--with-external_ap"

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