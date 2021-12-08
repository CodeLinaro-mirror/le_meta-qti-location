include $(TOPDIR)/rules.mk

PKG_NAME:=location-qapi
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/qapi

CONFIGURE_ARGS += --with-glib --with-core-includes=$(TOPDIR)/src/system/core/include
TARGET_CFLAGS += -I$(STAGING_DIR)/usr/include/glib-2.0/ -DUSE_ANDROID_LOGGING -DUSE_MUSL -DOPENWRT_BUILD
TARGET_LDFLAGS += -llog

include $(INCLUDE_DIR)/package.mk

define Package/location-qapi
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Qapi
  DEPENDS:= +gps-utils +location-client-api
endef

define Package/location-qapi/Description
	Location Qapi package
endef

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include
	mkdir -p $(1)/usr/lib
	mkdir -p  $(1)/usr/share/pkgconfig
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)/usr/include/
	$(CP) $(PKG_BUILD_DIR)/.libs/liblocation_qapi.so* $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/location-qapi.pc $(1)/usr/share/pkgconfig/
endef

define Package/location-qapi/install
	$(INSTALL_DIR) $(1)/usr/lib/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/.libs/liblocation_qapi.so* $(1)/usr/lib/
endef

$(eval $(call BuildPackage,location-qapi))
