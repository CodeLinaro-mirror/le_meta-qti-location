include $(TOPDIR)/rules.mk

PKG_NAME:=location-client-api-testapp
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/client_api_testapp/

include ../location-common.mk

define Package/location-client-api-testapp
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Client Api TestApp
  DEPENDS:= +gps-utils +location-client-api +location-integration-api +location-hal-daemon
endef

define Package/location-client-api-testapp/Description
	Location client api Testapp
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR) $(1)$(USR_BIN_DIR)
	$(MKDIR)  $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/location_client_api_testapp $(1)$(USR_BIN_DIR)
	$(CP) $(PKG_BUILD_DIR)/location_client_api_testapp.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-client-api-testapp/install
	$(INSTALL_DIR) $(1)$(USR_BIN_DIR)
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/location_client_api_testapp $(1)$(USR_BIN_DIR)
endef

$(eval $(call BuildPackage,location-client-api-testapp))
