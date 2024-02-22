include $(TOPDIR)/rules.mk

PKG_NAME:=location-hal-daemon
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/location_hal_daemon/

include ../location-common.mk

define Package/location-hal-daemon
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Hal Daemon
  DEPENDS:= +glib2 +loc-pla-hdr +gps-utils +loc-hal +location-api-iface +location-api +location-api-msg-proto
endef

CONFIGURE_ARGS += --with-systemd

define Package/location-hal-daemon/Description
	Location Hal Daemon
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
	$(MKDIR) $(1)$(SYS_CONF_DIR)init.d
	$(MKDIR) $(1)$(SYS_CONF_DIR)capabilities
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/location_hal_daemon $(1)$(USR_BIN_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-hal-daemon.pc $(1)$(USR_PKGCFG_DIR)
	$(CP) ./files/location-hal-daemon.init $(1)$(SYS_CONF_DIR)init.d/
	$(CP) ./files/location-hal-daemon.json $(1)$(SYS_CONF_DIR)capabilities/
endef

define Package/location-hal-daemon/install
	$(INSTALL_DIR) $(1)$(USR_BIN_DIR)
	$(INSTALL_DIR) $(1)$(SYS_CONF_DIR)init.d
	$(INSTALL_DIR) $(1)$(SYS_CONF_DIR)capabilities
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/location_hal_daemon $(1)$(USR_BIN_DIR)
	$(INSTALL_BIN) ./files/location-hal-daemon.init $(1)$(SYS_CONF_DIR)init.d/
	$(INSTALL_DATA) ./files/location-hal-daemon.json $(1)$(SYS_CONF_DIR)capabilities/
endef

$(eval $(call BuildPackage,location-hal-daemon))
