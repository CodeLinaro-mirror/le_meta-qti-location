# Common defines applicable for all location BB files
inherit locationcommon

EXTRA_OECONF = "--with-locpla-includes=${STAGING_INCDIR}/loc-pla \
                --with-core-includes=${WORKSPACE}/system/core/include \
                --with-glib"

# enabling logcat for target which supports logd in both internal and external builds.
# link with liblog, this library will take care of directing to logcat if logd is enabled, else
# will redirect to default logging system.
CFLAGS_append = "${@loc_target_in_list('mdm9650', '', '', ' -DUSE_ANDROID_LOGGING', d)}"
CPPFLAGS_append = "${@loc_target_in_list('mdm9650', '', '', ' -DUSE_ANDROID_LOGGING', d)}"
LDFLAGS_append = "${@loc_target_in_list('mdm9650', '', '', ' -llog', d)}"
