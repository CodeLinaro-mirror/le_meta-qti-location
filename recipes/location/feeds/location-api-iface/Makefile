include $(TOPDIR)/rules.mk

PKG_NAME:=location-api-iface
PKG_VERSION:=1.0
PKG_RELEASE:=1

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/location/

include $(INCLUDE_DIR)/package.mk

TARGET_CFLAGS += -DUSE_MUSL -DOPENWRT_BUILD

define Package/location-api-iface
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Api Iface
endef

define Package/location-api-iface/Description
	Location api interface package
endef

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/Configure
	@true
endef

define Build/Compile
	@true
endef

define Build/InstallDev
	$(INSTALL_DIR) $(1)/usr/include/
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)/usr/include/
endef

define Package/location-api-iface/install
	@true
endef


$(eval $(call BuildPackage,location-api-iface))
