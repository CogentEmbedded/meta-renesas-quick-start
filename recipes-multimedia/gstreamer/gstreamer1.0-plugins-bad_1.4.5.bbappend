FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PACKAGECONFIG_append=" faad"

SRC_URI_append = " \
    file://0001-install-wayland.h-header.patch \
    file://0002-pkgconfig-libgstwayland.patch \
"
