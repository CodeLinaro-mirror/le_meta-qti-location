include $(TOPDIR)/rules.mk

PKG_NAME:=qcom-gps-utils
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/utils

include ../location-common.mk

TARGET_LDFLAGS += -lexecinfo

define Package/$(PKG_NAME)
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Gps Utils
  DEPENDS:= +glib2 +libexecinfo +libcutils +loc-pla-hdr +location-api-iface
endef

define Package/$(PKG_NAME)/Description
	GPS UTILS package
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
	$(CP) $(PKG_BUILD_DIR)/.libs/libgps_utils.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/qcom-gps-utils.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/$(PKG_NAME)/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/libgps_utils.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,$(PKG_NAME)))
