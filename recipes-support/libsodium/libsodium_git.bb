require libsodium.inc

SRC_URI = " git://github.com/jedisct1/libsodium.git "
SRCREV = "cbc1b89181d84fea20f8107fdd8b6ad79d2b2ce3"

LIC_FILES_CHKSUM = " file://LICENSE;md5=092a09b78c3be486fac807435bf17b7a"

S = "${WORKDIR}/git"

PV = "1.1.0a"

DEFAULT_PREFERENCE = "-1"
