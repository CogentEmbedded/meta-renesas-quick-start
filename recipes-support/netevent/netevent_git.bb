SUMMARY = "netevent - share input devices over net"
SECTION = "misc"

LICENSE = "CLOSED"

PN = "netevent"
PE = "1"
PV = "0.1"
PR = "r1"

SRC_URI = "git://github.com/CogentEmbedded/netevent.git"

SRCREV = "f022a37f31ab8a0f8269205a86f1aead97bb8936"

S = "${WORKDIR}/git"

B = "${S}"

do_install() {
    install -d ${D}${bindir}

    install -m 0755 netevent ${D}${bindir}/
    install -m 0755 devname ${D}${bindir}/
}
