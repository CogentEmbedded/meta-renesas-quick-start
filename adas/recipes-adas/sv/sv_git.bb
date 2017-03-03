SUMMARY = "Cogent Embedded SuroundView utest application"
SECTION = "libs/multimedia"
LICENSE = "CLOSED"

DEPENDS = " \
    glib-2.0 \
    opencv \
    libegl \
    glm \
    zlib \
    cairo \
    nlopt \
    libeigen \
    pango \
    libspnav \
"
RDEPENDS_${PN} = "\
    gles-user-module \
    spacenavd \
"

SRC_URI = "git://github.com/CogentEmbedded/sv-utest.git;branch=master"
SRCREV = "a35dbababb732fc91ff3fa9fbc5733b462e95079"
S = "${WORKDIR}/git"
PV = "git+${SRCREV}"

inherit cmake

EXTRA_OECMAKE += " -DSV_TARGET_PLATFORM=GEN2"

do_install_append() {
	install -d ${D}${libdir}
	install -d ${D}/usr/include
	install -m 755 ${S}/libs/gen2/libsv.so ${D}${libdir}
	install -d ${D}/home/root/sv
        cp -r ${S}/include/sv ${D}/usr/include
        cp -r ${S}/resources/* ${D}/home/root/sv
}

FILES_${PN} += " \
    ${libdir}/libsv.so \
    /home/root/sv \
    /usr/include \
"

INSANE_SKIP_${PN} += "already-stripped"

