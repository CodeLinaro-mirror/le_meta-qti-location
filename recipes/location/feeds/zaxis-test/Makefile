include $(TOPDIR)/rules.mk

PKG_NAME:=zaxis-test
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause-Clear
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/zaxis-test

include ../locationprop-common.mk

define Package/zaxis-test
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Z-Axis test app
  DEPENDS:= +glib2 +qcom-gps-utils +izat-client-api +nlp-api-hdr +loc-mq-client
endef

define Package/zaxis-test/Description
	Z-Axis test application
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_BIN_DIR)
	$(MKDIR) $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/zaxis_test $(1)$(USR_BIN_DIR)
	$(CP) $(PKG_BUILD_DIR)/zaxis-test.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/zaxis-test/install
	$(INSTALL_DIR) $(1)$(USR_BIN_DIR)
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/zaxis_test $(1)$(USR_BIN_DIR)
endef

$(eval $(call BuildPackage,zaxis-test))
