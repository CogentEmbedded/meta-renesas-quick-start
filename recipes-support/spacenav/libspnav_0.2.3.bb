SUMMARY = "SpaceNavigator 3D-mouse daemon interface library"
SECTION = "libs/multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README;md5=a8f5600270c9340ba8f2d956133a91d3"

SRC_URI = " \
	file://libspnav-0.2.3.tar.gz \
	file://0001-libspnav-cross-compile.patch \
	file://0002-Fix-configuration-for-libdir.patch \
"

SRC_URI[md5sum] = "44d840540d53326d4a119c0f1aa7bf0a"
SRC_URI[sha256sum] = "7ae4d7bb7f6a5dda28b487891e01accc856311440f582299760dace6ee5f1f93"

S = "${WORKDIR}/libspnav-${PV}"

inherit autotools pkgconfig

B = "${WORKDIR}/libspnav-${PV}"

# Disable X11 protocol
EXTRA_OECONF = "--disable-x11"

FILES_${PN} = " ${libdir} "
