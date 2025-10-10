include $(TOPDIR)/rules.mk

PKG_NAME:=loc-core
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/core/

include ../location-common.mk

define Package/loc-core
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Core
  DEPENDS:= +qcom-gps-utils
endef

define Package/loc-core/Description
	Location Core package
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
	$(CP) $(PKG_BUILD_DIR)/data-items/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/observer/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/.libs/libloc_core.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/loc-core.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/loc-core/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/libloc_core.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,loc-core))
