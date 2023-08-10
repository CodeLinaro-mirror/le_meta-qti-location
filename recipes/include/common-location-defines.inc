# Common defines applicable for all location BB files

# qcommon bbclass
# Common bitbake recipe information for QTI meta layers.
# Below are common values, statements and functions.
#
FILESPATH        =+ "${WORKSPACE}:"
SRC_URI          = "file://${@d.getVar('SRC_DIR', True).replace('${WORKSPACE}/', '')}"
PACKAGE_ARCH    ?= "${MACHINE_ARCH}"

# packageconfig for location automotive
## legacy LE Auto targets
PACKAGECONFIG ??= "${@oe.utils.conditional('DISTRO', 'auto', 'loc-automotive', '', d)}"
## PDK based LE Auto targets
PACKAGECONFIG_sa415m  = "loc-automotive loc-bootkpi "
PACKAGECONFIG_mdm9607 = "loc-automotive "

PACKAGECONFIG[loc-automotive] = "--with-auto_feature"

CFLAGS_append_sdxpoorwills = " -DUSE_ANDROID_LOGGING "
CPPFLAGS_append_sdxpoorwills = " -DUSE_ANDROID_LOGGING "
LDFLAGS_append_sdxpoorwills = " -llog "

CFLAGS_append_mdm9607 = " -DUSE_ANDROID_LOGGING "
CPPFLAGS_append_mdm9607 = " -DUSE_ANDROID_LOGGING "
LDFLAGS_append_mdm9607 = " -llog "

