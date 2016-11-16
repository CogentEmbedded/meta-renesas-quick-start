SUMMARY = "netevent - share input devices over net"
SECTION = "misc"

LICENSE = "CLOSED"

PN = "netevent"
PE = "1"
PV = "0.1"
PR = "r1"

SRC_URI = "git://github.com/Blub/netevent.git \
    file://0001-fix-endian-for-cross-arch.patch \
    file://0002-fix-cross-compile.patch \
    file://0003-use-socket-instead-of-stdout.patch \
    file://0004-Add-TCP-keep-alive-to-handle-peer-death-properly.patch \
"

SRCREV = "06f1fe545f2063ae882fc8b66dc07f1ced85d1da"

S = "${WORKDIR}/git"

B = "${S}"

do_install() {
    install -d ${D}${bindir}

    install -m 0755 netevent ${D}${bindir}/
    install -m 0755 devname ${D}${bindir}/
}
