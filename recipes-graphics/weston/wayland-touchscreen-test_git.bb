DESCRIPTION = "Simple Wayland Touchsreen Test"
AUTHOR = "Dmitry Cherkassov"
HOMEPAGE = "https://bitbucket.org/dcherkassov/wayland-touchscreen-test"
SECTION = "graphics"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "weston"

SRC_URI = "git://bitbucket.org/dcherkassov/wayland-touchscreen-test.git;protocol=https;tag=master \
        file://COPYING \
        file://0001-add-clean-target.patch \
"
PR="r1"

inherit autotools

S = "${WORKDIR}/git"
B = "${S}"

do_compile() {
    make clean
    base_do_compile
}

do_install() {
  install -d ${D}/home/root/simple-touch/
  install -m 755 ${S}/simple-touch ${D}/home/root/simple-touch/
}


FILES_${PN} = "/home/root/simple-touch"
FILES_${PN}-dbg = "/home/root/simple-touch/.debug /usr/src/debug/wayland-touchscreen-test"  
