include $(TOPDIR)/rules.mk

PKG_NAME:=location-api
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/location/

include ../location-common.mk

define Package/location-api
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Api Inteface
  DEPENDS:= +gps-utils
endef

define Package/location-api/Description
	Location api interface library
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
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/.libs/liblocation_api.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-api.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-api/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/liblocation_api.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,location-api))
