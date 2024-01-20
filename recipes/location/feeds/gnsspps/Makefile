include $(TOPDIR)/rules.mk

PKG_NAME:=gnsspps
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/gnsspps/

include ../location-common.mk

define Package/gnsspps
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location GNSS PPS library
  DEPENDS:= +gps-utils
endef

define Package/gnsspps/Description
	Location GNSS PPS library
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR)  $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/gnsspps.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/.libs/libgnsspps.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/gnsspps.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/gnsspps/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/libgnsspps.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,gnsspps))
