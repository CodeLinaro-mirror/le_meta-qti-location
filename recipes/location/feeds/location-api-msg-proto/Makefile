include $(TOPDIR)/rules.mk

PKG_NAME:=location-api-msg-proto
PKG_VERSION:=1.0
PKG_RELEASE:=1
PKG_FIXUP:=autoreconf

LOCAL_SRC ?= $(TOPDIR)/src/qcom-opensource/location/location_api_msg_proto/

CONFIGURE_ARGS += --with-glib --with-core-includes=$(TOPDIR)/src/system/core/include
TARGET_CFLAGS += -I$(STAGING_DIR)/usr/include/glib-2.0/ -DUSE_ANDROID_LOGGING -DUSE_MUSL -DOPENWRT_BUILD
TARGET_LDFLAGS += -llog

include $(INCLUDE_DIR)/package.mk

define Package/location-api-msg-proto
  SECTION:=QTI
  CATEGORY:=QTI-PACKAGES
  TITLE:=Loc Api Msg Protobuf Lib
  DEPENDS:= +glib2 +protobuf +loc-pla-hdr +gps-utils
endef

PKG_BUILD_DEPENDS:= protobuf/host

define Package/location-api-msg-proto/Description
	Location api msg protobuf library
endef


define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)/
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
	/bin/sh $(PKG_BUILD_DIR)/protobuf_gen.sh $(STAGING_DIR_HOSTPKG)
endef

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include
	mkdir -p $(1)/usr/lib
	mkdir -p  $(1)/usr/share/pkgconfig
	$(CP) $(PKG_BUILD_DIR)/src/*.h $(1)/usr/include/
	$(CP) $(PKG_BUILD_DIR)/src/.libs/liblocation_api_msg_proto.so* $(1)/usr/lib/
	$(CP) $(PKG_BUILD_DIR)/location-api-msg-proto.pc $(1)/usr/share/pkgconfig/
endef

define Package/location-api-msg-proto/install
	$(INSTALL_DIR) $(1)/usr/lib/
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/src/.libs/liblocation_api_msg_proto.so* $(1)/usr/lib/
endef

$(eval $(call BuildPackage,location-api-msg-proto))
