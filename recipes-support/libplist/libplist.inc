HOMEPAGE = "http://www.libimobiledevice.org/"
DESCRIPTION = "A small portable C library to handle Apple Property List files in binary or XML."
LICENSE = "GPLv2 | LGPLv2.1"

inherit pkgconfig autotools

DEPENDS = "libxml2"

LIC_FILES_CHKSUM = " \
	file://COPYING;md5=ebb5c50ab7cab4baeffba14977030c07 \
	file://COPYING.LESSER;md5=6ab17b41640564434dda85c06b7124f7 \
"

EXTRA_OECONF = "--without-cython"
