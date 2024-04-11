include $(TOPDIR)/rules.mk

PKG_NAME:=loc-pla-hdr
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause

LOCAL_SRC ?= $(TOPDIR)/src/hardware/qcom/gps/pla/oe/

include ../location-common.mk

define Package/loc-pla-hdr
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Platform Lib Abstraction
endef

define Package/loc-pla-hdr/Description
	GPS Loc Platform Library Abstraction
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Build/Configure
	@true
endef

define Build/Compile
	@true
endef

define Build/InstallDev
	$(INSTALL_DIR) $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/*.h $(1)$(USR_INC_DIR)
endef

define Package/loc-pla-hdr/install
	@true
endef

$(eval $(call BuildPackage,loc-pla-hdr))
