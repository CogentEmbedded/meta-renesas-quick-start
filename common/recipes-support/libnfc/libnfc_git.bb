SUMMARY = "Public platform independent Near Field Communication (NFC) library"
DESCRIPTION = "libnfc is a library which allows userspace application access to NFC devices."
HOMEPAGE = "http://www.libnfc.org/"
BUGTRACKER = "http://code.google.com/p/libnfc/issues/list"


LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=b52f2d57d10c4f7ee67a7eb9615d5d24"

SRC_URI = "git://github.com/nfc-tools/libnfc.git"
SRCREV = "master"
SRC_URI[md5sum] = "9634c7a1f09166efcd4d850e3f857766"
SRC_URI[sha256sum] = "5c31803c725c209716a0fbdcffa3e599a381a2b3700f3ac4c2e1d940f920ac9e"
PR = "r0"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
