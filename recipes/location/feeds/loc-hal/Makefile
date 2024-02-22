include $(TOPDIR)/rules.mk

PKG_NAME:=loc-hal
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/

include ../location-common.mk

define Package/loc-hal
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=GPS Loc HAL
  DEPENDS:= +loc-core +libxml2
  USERID:=gps=1021:gps=1021 locclient=4021:locclient=4021
endef

define Package/loc-hal/Description
	GPS Loc HAL package
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(MKDIR) $(PKG_BUILD_DIR)/gnss/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(SYS_CONF_DIR)
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR) $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/etc/gps.conf $(1)$(SYS_CONF_DIR)
	$(CP) $(PKG_BUILD_DIR)/gnss/.libs/libgnss.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/loc-hal.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/loc-hal/install
	$(INSTALL_DIR) $(1)$(SYS_CONF_DIR)
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LOCATION_CONF) $(PKG_BUILD_DIR)/etc/gps.conf $(1)$(SYS_CONF_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/gnss/.libs/libgnss.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,loc-hal))
