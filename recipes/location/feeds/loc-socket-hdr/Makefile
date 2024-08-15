include $(TOPDIR)/rules.mk

PKG_NAME:=loc-socket-hdr
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause & BSD-3-Clause-Clear

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/utils/loc_socket/

include ../location-common.mk

define Package/loc-socket-hdr
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Location Socket Header library
endef

define Package/loc-socket-hdr/Description
    Location Socket Header library
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

define Package/loc-socket-hdr/install
    @true
endef

$(eval $(call BuildPackage,loc-socket-hdr))
