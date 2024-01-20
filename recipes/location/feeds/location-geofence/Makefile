include $(TOPDIR)/rules.mk

PKG_NAME:=location-geofence
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/geofence/

include ../location-common.mk

define Package/location-geofence
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=GPS Geofence
  DEPENDS:= +lbs-core-hdr +lbs-core
endef

define Package/location-geofence/Description
	GPS Geofence library
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR) $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/.libs/libgeofencing.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-geofence.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-geofence/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/libgeofencing.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,location-geofence))
