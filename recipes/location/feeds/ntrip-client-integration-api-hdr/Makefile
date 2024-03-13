include $(TOPDIR)/rules.mk

PKG_NAME:=ntrip-client-integration-api-hdr
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/ntrip-client-integration-api/

include ../location-common.mk

define Package/ntrip-client-integration-api-hdr
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Ntrip client integration Api Header library
endef

define Package/ntrip-client-integration-api-hdr/Description
	Ntrip client integration Api Header library
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

define Package/ntrip-client-integration-api-hdr/install
	@true
endef

$(eval $(call BuildPackage,ntrip-client-integration-api-hdr))
