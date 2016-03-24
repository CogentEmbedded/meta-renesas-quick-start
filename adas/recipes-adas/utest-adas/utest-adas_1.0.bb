# the recipe is named with ${PV}=v0.xxx to take precedence over the open-source one in meta-renesas-quick-start
require ${PN}.inc

inherit cmake

DEPENDS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    libspnav \
    libpcap \
    libegl \
    wayland \
    zlib \
    cairo \
    mesa \
    sv \
"
RDEPENDS_${PN} = "\
    gles-user-module \
    spacenavd \
"

SRC_URI = "git://github.com/CogentEmbedded/utest-adas.git;protocol=http;branch=${PV}"
S = "${WORKDIR}/git"
SRCREV = "1.0"

FILES_${PN} += "${datadir}/${BPN}"

# Temporary fix
EXTRA_OECMAKE += "-DBINARY_DIR=${bindir}"

