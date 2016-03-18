# the recipe is named with ${PV}=v0.0.xxx to take precedence over the default one in meta-renesas-quick-start
require ${PN}.inc

DEPENDS = " \
    glib-2.0 \
    opencv \
    libegl \
    glm \
    zlib \
    cairo \
    mesa \
    nlopt \
    libeigen \
    pango \
"
RDEPENDS_${PN} = "\
    gles-user-module \
    spacenavd \
"

SRC_URI = "file://sv_prebuilt_v${PV}.tar.bz2"
S = "${WORKDIR}/sv_prebuilt_v${PV}"

# do not execute tasks for precompiled binaries
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
	install -d ${D}
	cd ${S}/common
	cp -r * ${D}
}

do_install_append_r8a7790() {
	cd ${S}/r8a7790
	cp -r * ${D}
}

do_install_append_r8a7791() {
	cd ${S}/r8a7791
	cp -r * ${D}
}

do_install_append_r8a7795() {
	cd ${S}/r8a7795
	cp -r * ${D}
}

FILES_${PN} += " \
    ${libdir}/*.so \
"

FILES_${PN}-dev = " \
    ${includedir}/* \
"

INSANE_SKIP_${PN} += "already-stripped"

