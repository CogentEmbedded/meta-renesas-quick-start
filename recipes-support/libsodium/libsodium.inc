SUMMARY = "Sodium is a new, easy-to-use software library for encryption, decryption, signatures, password hashing and more."
HOMEPAGE = "https://github.com/jedisct1/libsodium"
LICENSE = "ISC"

LIC_FILES_CHKSUM = " file://LICENSE;md5=45f663da318938d084d04c829ecb98ad"

SRC_URI = "https://github.com/jedisct1/libsodium/releases/download/${PV}/${PN}-${PV}.tar.gz "

inherit autotools pkgconfig

