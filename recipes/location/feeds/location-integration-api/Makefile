include $(TOPDIR)/rules.mk

PKG_NAME:=location-integration-api
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/integration_api/

include ../location-common.mk

define Package/location-integration-api
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Integration Api
  DEPENDS:= +glib2 +libcutils +loc-pla-hdr +qcom-gps-utils +location-api-msg-proto +location-client-api-hdr +loc-diag-iface-hdr
endef

define Package/location-integration-api/Description
	Location integration api library
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR)  $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/src/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/.libs/liblocation_integration_api.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-integration-api.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-integration-api/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/liblocation_integration_api.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,location-integration-api))
