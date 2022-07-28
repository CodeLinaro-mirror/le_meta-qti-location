include $(TOPDIR)/rules.mk

PKG_NAME:=location-qapi
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/qapi

include ../location-common.mk

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
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR) $(1)$(SYS_CONF_DIR)
	$(MKDIR)  $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/inc/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/etc/qapi.conf $(1)$(SYS_CONF_DIR)
	$(CP) $(PKG_BUILD_DIR)/.libs/liblocation_qapi.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-qapi.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-qapi/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_DIR) $(1)$(SYS_CONF_DIR)
	$(INSTALL_LOCATION_CONF) $(PKG_BUILD_DIR)/etc/qapi.conf $(1)$(SYS_CONF_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/liblocation_qapi.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,location-qapi))
