include $(TOPDIR)/rules.mk

PKG_NAME:=location-api-iface
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/location/

include ../location-common.mk

define Package/location-api-iface
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Api Iface headers
endef

define Package/location-api-iface/Description
	Location api interface package headers
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/Configure
	@true
endef

define Build/Compile
	@true
endef

define Build/InstallDev
	$(INSTALL_DIR) $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)
endef

define Package/location-api-iface/install
	@true
endef


$(eval $(call BuildPackage,location-api-iface))
