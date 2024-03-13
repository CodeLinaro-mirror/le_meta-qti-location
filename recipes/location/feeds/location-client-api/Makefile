include $(TOPDIR)/rules.mk

PKG_NAME:=location-client-api
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/client_api/

include ../location-common.mk

define Package/location-client-api
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Client Api
  DEPENDS:= +glib2 +libcutils +loc-pla-hdr +gps-utils +location-api-msg-proto
endef

define Package/location-client-api/Description
	Location client api library
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
	$(CP) $(PKG_BUILD_DIR)/.libs/liblocation_client_api.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-client-api.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-client-api/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/liblocation_client_api.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,location-client-api))
