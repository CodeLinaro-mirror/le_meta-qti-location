include $(TOPDIR)/rules.mk

PKG_NAME:=loc-hal
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/

CONFIGURE_ARGS += --with-glib --with-core-includes=$(TOPDIR)/src/system/core/include
TARGET_CFLAGS += -I$(STAGING_DIR)/usr/include/glib-2.0/ -DUSE_ANDROID_LOGGING -DUSE_MUSL -DOPENWRT_BUILD
TARGET_LDFLAGS += -llog

include $(INCLUDE_DIR)/package.mk

define Package/loc-hal
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=GPS Loc HAL
  DEPENDS:= +loc-core
endef

define Package/loc-hal/Description
	GPS Loc HAL package
endef

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include
	mkdir -p  $(1)/usr/share/pkgconfig
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)/usr/include/
	$(CP) $(PKG_BUILD_DIR)/loc-hal.pc $(1)/usr/share/pkgconfig/
endef

define Package/loc-hal/install
	$(INSTALL_DIR) $(1)/etc/
	$(CP) $(PKG_BUILD_DIR)/etc/gps.conf $(1)/etc/
endef

$(eval $(call BuildPackage,loc-hal))
