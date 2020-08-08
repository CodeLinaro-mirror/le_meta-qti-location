# Common defines applicable for all location BB files

# qcommon bbclass
# Common bitbake recipe information for QTI meta layers.
# Below are common values, statements and functions.
#
FILESPATH        =+ "${WORKSPACE}:"
SRC_URI          = "file://${@d.getVar('SRC_DIR', True).replace('${WORKSPACE}/', '')}"
PACKAGE_ARCH    ?= "${MACHINE_ARCH}"

# enabling logcat for target which supports logd in both internal and external builds.
CFLAGS_append_mdm9607 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_mdm9607 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_mdm9607 = " -llog"

CFLAGS_append_apq8096 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_apq8096 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_apq8096 = " -llog"

CFLAGS_append_apq8098 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_apq8098 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_apq8098 = " -llog"

CFLAGS_append_qcs605 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_qcs605 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_qcs605 = " -llog"

CFLAGS_append_sdm845 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_sdm845 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_sdm845 = " -llog"

CFLAGS_append_apq8017 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_apq8017 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_apq8017 = " -llog"

CFLAGS_append_apq8009 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_apq8009 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_apq8009 = " -llog"

CFLAGS_append_apq8053 = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_apq8053 = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_apq8053 = " -llog"

CFLAGS_append_qcs40x = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_qcs40x = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_qcs40x = " -llog"

CFLAGS_append_sdmsteppe = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_sdmsteppe = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_sdmsteppe = " -llog"

CFLAGS_append_sdxlemur = " -DUSE_ANDROID_LOGGING"
CPPFLAGS_append_sdxlemur = " -DUSE_ANDROID_LOGGING"
LDFLAGS_append_sdxlemur = " -llog"
