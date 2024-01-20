include $(TOPDIR)/rules.mk

PKG_NAME:=loc-api-v02
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/loc_api/loc_api_v02/

include ../location-common.mk

define Package/loc-api-v02
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location QMI Api library
  DEPENDS:= +libutils +loc-core +qmi-framework
endef

define Package/loc-api-v02/Description
	Location QMI Api library
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
	$(CP) $(PKG_BUILD_DIR)/.libs/libloc_api_v02.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/loc-api-v02.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/loc-api-v02/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/libloc_api_v02.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,loc-api-v02))
