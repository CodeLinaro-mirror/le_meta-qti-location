# Location specific macro definitions for OpenWrt
include $(INCLUDE_DIR)/package.mk

# Default configs
CONFIGURE_ARGS += --with-glib --with-core-includes=$(TOPDIR)/src/system/core/include
TARGET_CFLAGS += -I$(STAGING_DIR)/usr/include/glib-2.0/ -DUSE_ANDROID_LOGGING -DUSE_MUSL -DOPENWRT_BUILD -fpic
TARGET_LDFLAGS += -llog

# Enable Target specific compiledr defines
ifeq ($(BOARD),sdx75)
	TARGET_CFLAGS += -DOPENWRT_TARGET_SDX75
else ifeq ($(BOARD),sdx35)
	TARGET_CFLAGS += -DOPENWRT_TARGET_SDX35 -DFEATURE_NHZ_ENABLED
endif

# Define WORKSPACE variable which is used in autoconf makefiles.
MAKE_FLAGS += WORKSPACE=$(TOPDIR)/src

# Add macro for few more commonly used commands
MKDIR:=mkdir -p

# install commands
INSTALL_LIBS:=$(CP)
INSTALL_LOCATION_CONF:=install -m0644

# common directories
SYS_CONF_DIR:=/etc/
USR_LIB_DIR:=/usr/lib/
USR_BIN_DIR:=/usr/bin/
USR_INC_DIR:=/usr/include/
USR_PKGCFG_DIR:=/usr/share/pkgconfig/