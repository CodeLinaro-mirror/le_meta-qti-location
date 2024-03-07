include $(TOPDIR)/rules.mk

PKG_NAME:=loc-socket
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/utils/loc_socket/

include ../location-common.mk

define Package/loc-socket
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Socket library
  DEPENDS:= +glib2 +libcutils +loc-pla-hdr +gps-utils
endef

define Package/loc-socket/Description
	Location Socket library
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
	$(CP) $(PKG_BUILD_DIR)/.libs/libloc_socket.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/loc-socket.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/loc-socket/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/.libs/libloc_socket.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,loc-socket))
