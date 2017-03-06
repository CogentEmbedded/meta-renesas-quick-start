SUMMARY = "Userspace library to SpaceNavigator 3D-mouse"
SECTION = "libs/multimedia"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

BBCLASSEXTEND = "native nativesdk"

SRC_URI = " \
	file://spacenavd-0.6.tar.gz \
	file://0001-spacenavd-cross-compile.patch \
	file://0002-Fix-build-configuration.patch \
"

SRC_URI[md5sum] = "7e2c04fb8dbb7d39b9ee7b64565e0c4f"
SRC_URI[sha256sum] = "c2d203bf96c5a959590146a43fe5d6e5e8c5c38a8b2f55aa199d967d0d88d0ab"

S = "${WORKDIR}/spacenavd-${PV}"
B = "${S}"

inherit autotools pkgconfig useradd systemd

# Don't configure udev by default since it will cause a circular
# dependecy with udev package, which depends on libusb
EXTRA_OECONF = " --disable-x11"

SRC_URI_append = " file://spacenavd.service"

SYSTEMD_SERVICE_${PN} = "spacenavd.service"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system spacenavd"

do_install_append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system/
        install -m 0644 ${WORKDIR}/spacenavd.service ${D}${systemd_unitdir}/system/
    fi
}

