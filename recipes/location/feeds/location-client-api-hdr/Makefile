include $(TOPDIR)/rules.mk

PKG_NAME:=location-client-api-hdr
PKG_VERSION:=1.0
PKG_RELEASE:=1

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/client_api/inc/

include ../location-common.mk

define Package/location-client-api-hdr
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Client Api Header library
endef

define Package/location-client-api-hdr/Description
	Location Client Api Header library
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

define Package/location-client-api-hdr/install
	@true
endef

$(eval $(call BuildPackage,location-client-api-hdr))
