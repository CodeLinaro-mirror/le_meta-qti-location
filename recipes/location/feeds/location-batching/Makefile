include $(TOPDIR)/rules.mk

PKG_NAME:=location-batching
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/batching/

include ../location-common.mk

define Package/location-batching
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=GPS FLP Batching library
  DEPENDS:= +lbs-core-hdr +loc-api-v02 +qcom-gps-utils +loc-base-util
endef

define Package/location-batching/Description
	GPS FLP Batching library
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
	$(CP) $(TOPDIR)/src/hardware/qcom/gps/etc/batching.conf $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(SYS_CONF_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR) $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/batching.conf $(1)$(SYS_CONF_DIR)
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/.libs/libbatching.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-batching.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-batching/install
	$(INSTALL_DIR) $(1)$(SYS_CONF_DIR)
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LOCATION_CONF) $(PKG_BUILD_DIR)/batching.conf $(1)$(SYS_CONF_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/libbatching.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,location-batching))
