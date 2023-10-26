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

CFLAGS:append:sdxpoorwills = " -DUSE_ANDROID_LOGGING "
CPPFLAGS:append:sdxpoorwills = " -DUSE_ANDROID_LOGGING "
LDFLAGS:append:sdxpoorwills = " -llog "

CFLAGS:append:mdm9607 = " -DUSE_ANDROID_LOGGING "
CPPFLAGS:append:mdm9607 = " -DUSE_ANDROID_LOGGING "
LDFLAGS:append:mdm9607 = " -llog "

