SUMMARY = "Userspace library to SpaceNavigator 3D-mouse"
SECTION = "libs/multimedia"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

BBCLASSEXTEND = "native nativesdk"

SRC_URI = " \
	file://spacenavd-0.6.tar.gz \
	file://spacenavd-cross-compile.patch \
"

SRC_URI[md5sum] = "7e2c04fb8dbb7d39b9ee7b64565e0c4f"
SRC_URI[sha256sum] = "c2d203bf96c5a959590146a43fe5d6e5e8c5c38a8b2f55aa199d967d0d88d0ab"

S = "${WORKDIR}/spacenavd-${PV}"

inherit autotools pkgconfig

# Don't configure udev by default since it will cause a circular
# dependecy with udev package, which depends on libusb
EXTRA_OECONF = "--disable-x11"

#do_install_append() {
#	install -d ${D}${libdir}
#	if [ ! ${D}${libdir} -ef ${D}${base_libdir} ]; then
#		mv ${D}${base_libdir}/pkgconfig ${D}${libdir}
#	fi
#}

#FILES_${PN} += "${base_libdir}/*.so.*"

#FILES_${PN}-dev += "${base_libdir}/*.so ${base_libdir}/*.la"
