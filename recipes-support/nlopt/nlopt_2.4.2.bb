require ${PN}.inc

SRC_URI = "https://github.com/stevengj/${BPN}/archive/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "5f60160dd0cb0f7c4fed983940bd5224"
SRC_URI[sha256sum] = "d838b5b4b1c6b6493666ff61a8817a4ebcee924f54fb95f6f64e5f727ddbf2a6"

S = "${WORKDIR}/${BPN}-${BPN}-${PV}"
