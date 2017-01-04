DESCRIPTION = "IMR surround view utest application"
HOMEPAGE    = "http://cogentembedded.com/"
LICENSE     = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f84529d052eac7c6b5769406536110f"

inherit cmake

DEPENDS = "\
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    wayland \
    zlib \
    cairo \
    pango \
    libspnav \
    vspm-user-module \
    mmngr-user-module \
    mmngrbuf-user-module \
"

RDEPENDS_${PN} = "\
    kernel-module-vspm \
    kernel-module-mmngr \
    kernel-module-mmngrbuf \
    spacenavd \
"

SRC_URI="gitsm://github.com/CogentEmbedded/imr-sv-utest.git;protocol=https;branch=master \
	file://0001-add-weston-scaler-interface.patch \
	file://run-utest-imr-sv \
"
SRCREV="12de3bb4ba24f09f615746629e5c2966336158c2"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git/"

inherit cmake

do_install_append(){
   # install resources
   install -d  ${D}/usr/share/${PN} ${D}/usr/bin/
   cp -rf  ${S}/resourses/* ${D}/usr/share/${PN}/
   install -m 0755 ${WORKDIR}/run-utest-imr-sv ${D}/usr/bin/
}
