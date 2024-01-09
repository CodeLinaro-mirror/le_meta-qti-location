include $(TOPDIR)/rules.mk

PKG_NAME:=location-api-msg-proto
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/location_api_msg_proto/

include ../location-common.mk

define Package/location-api-msg-proto
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Loc Api Msg Protobuf Lib
  DEPENDS:= +glib2 +protobuf +loc-pla-hdr +qcom-gps-utils
endef

PKG_BUILD_DEPENDS:= protobuf/host

define Package/location-api-msg-proto/Description
	Location api msg protobuf library
endef

define Build/Prepare
	$(MKDIR) $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
	/bin/sh $(PKG_BUILD_DIR)/protobuf_gen.sh $(STAGING_DIR_HOSTPKG)
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	$(MKDIR) $(1)$(USR_INC_DIR)
	$(MKDIR) $(1)$(USR_LIB_DIR)
	$(MKDIR)  $(1)$(USR_PKGCFG_DIR)
	$(CP) $(PKG_BUILD_DIR)/src/*.h $(1)$(USR_INC_DIR)
	$(CP) $(PKG_BUILD_DIR)/src/.libs/liblocation_api_msg_proto.so* $(1)$(USR_LIB_DIR)
	$(CP) $(PKG_BUILD_DIR)/location-api-msg-proto.pc $(1)$(USR_PKGCFG_DIR)
endef

define Package/location-api-msg-proto/install
	$(INSTALL_DIR) $(1)$(USR_LIB_DIR)
	$(INSTALL_LIBS) $(PKG_BUILD_DIR)/src/.libs/liblocation_api_msg_proto.so* $(1)$(USR_LIB_DIR)
endef

$(eval $(call BuildPackage,location-api-msg-proto))
