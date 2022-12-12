# Common defines applicable for all location BB files
inherit locationcommon

# qcommon bbclass
# Common bitbake recipe information for QTI meta layers.
# Below are common values, statements and functions.
#
FILESPATH        =+ "${WORKSPACE}:"
SRC_URI          = "file://${@d.getVar('SRC_DIR', True).replace('${WORKSPACE}/', '')}"
PACKAGE_ARCH    ?= "${MACHINE_ARCH}"

EXTRA_OECONF = "--with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"

# packageconfig for location automotive
## legacy LE Auto targets
PACKAGECONFIG ??= "${@oe.utils.conditional('DISTRO', 'auto', 'loc-automotive', '', d)}"
## PDK based LE Auto targets
PACKAGECONFIG_sa410m = "loc-automotive "
PACKAGECONFIG_sa515m = "loc-automotive loc-bootkpi "
PACKAGECONFIG[loc-automotive] = "--with-auto_feature"

# enabling logcat for target which supports logd in both internal and external builds.
# link with liblog, this library will take care of directing to logcat if logd is enabled, else
# will redirect to default logging system.
CFLAGS_append = "${@loc_target_in_list('mdm9650', '', '', ' -DUSE_ANDROID_LOGGING', d)}"
CPPFLAGS_append = "${@loc_target_in_list('mdm9650', '', '', ' -DUSE_ANDROID_LOGGING', d)}"
LDFLAGS_append = "${@loc_target_in_list('mdm9650', '', '', ' -llog', d)}"

