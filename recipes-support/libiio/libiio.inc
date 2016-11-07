DESCRIPTION = "Library for interfacing with IIO devices"
HOMEPAGE = "http://wiki.analog.com/resources/tools-software/linux-software/libiio"
SECTION = "System/Libraries"
LICENSE = "LGPL-2.1"

LIC_FILES_CHKSUM ??= "file://COPYING.txt;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"

inherit cmake pkgconfig

DEPENDS = "libxml2 bison-native flex-native"

