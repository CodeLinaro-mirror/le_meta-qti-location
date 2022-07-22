include $(TOPDIR)/rules.mk

PKG_NAME:=nlp-api-hdr
PKG_VERSION:=1.0
PKG_RELEASE:=1

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/nlp_api/inc/

include ../location-common.mk

define Package/nlp-api-hdr
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Nlp Api Header library
endef

define Package/nlp-api-hdr/Description
	Nlp Api Header library
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

define Package/nlp-api-hdr/install
	@true
endef

$(eval $(call BuildPackage,nlp-api-hdr))
