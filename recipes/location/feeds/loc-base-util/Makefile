include $(TOPDIR)/rules.mk

PKG_NAME:=loc-base-util
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/utils/base_util/

include ../location-common.mk

define Package/loc-base-util
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location base Util
  DEPENDS:= +liblog +glib2 +loc-pla-hdr +libopenssl +libsqlite3
endef

define Package/loc-base-util/Description
	Location base Util library
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
	$(MKDIR) $(PKG_BUILD_DIR)/base_util
	$(CP) $(LOCAL_SRC)/*.h $(PKG_BUILD_DIR)/base_util
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)base_util
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR) $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)base_util
	$(CP) $(PKG_BUILD_DIR)/src/.libs/libloc_base_util.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/loc-base-util.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/loc-base-util/install
	$(INSTALL_DIR) $(1)$(USR_INC_DIR)base_util
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/src/.libs/libloc_base_util.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,loc-base-util))
