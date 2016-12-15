SUMMARY = "Wayland IVI Extension"
DESCRIPTION = "GENIVI Layer Management API based on Wayland IVI Extension"
HOMEPAGE = "http://projects.genivi.org/wayland-ivi-extension"
BUGTRACKER = "http://bugs.genivi.org/enter_bug.cgi?product=Wayland%20IVI%20Extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1f1a56bb2dadf5f2be8eb342acf4ed79"

PR = "r2"

SRCREV = "851078b7bf499c334e8799f5cee181f1156f9907"

SRC_URI = "git://git.projects.genivi.org/${PN}.git \
    file://0002-include-wayland-egl-before-egl-in-surface-header.patch \
    file://0003-Wayland-IVI-Extension-patch-for-wl-shell-emulator.patch \
    "

S = "${WORKDIR}/git"

DEPENDS = "weston"

inherit cmake autotools

EXTRA_OECMAKE := "${@'-DWITH_ILM_INPUT=1 -DLIB_SUFFIX=64' if '${libdir}' == '/usr/lib64' else '-DWITH_ILM_INPUT=1'}"

FILES_${PN} += "${libdir}/weston/*"
FILES_${PN}-dbg += "${libdir}/weston/.debug/*" 
