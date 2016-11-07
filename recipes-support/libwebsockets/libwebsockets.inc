DESCRIPTION = "WebSocket Library"
HOMEPAGE = "http://libwebsockets.org/"
SECTION = "System/Libraries"
LICENSE = "LGPL-2.1"

LIC_FILES_CHKSUM ??= "file://LICENSE;md5=041a1dec49ec8a22e7f101350fd19550"

inherit cmake pkgconfig

# openssl is required for HTTPS (in theory ${PN} can be built without)
DEPENDS = "zlib openssl"

FILES_${PN} += " /usr/share/* /usr/lib/${PN}.so "
FILES_${PN}-dev += " /usr/lib/cmake/* "

