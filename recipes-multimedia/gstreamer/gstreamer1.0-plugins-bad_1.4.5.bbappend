FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "faad2"
PACKAGECONFIG_append += "faad"

SRC_URI_append = " \
    file://0001-install-wayland.h-header.patch \
    file://0002-pkgconfig-libgstwayland.patch \
    file://0003-fix_faad2_version_check.patch \
    file://0004-configure.ac-Fix-wayland-less-configuration.patch \
"
