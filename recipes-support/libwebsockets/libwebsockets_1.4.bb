require libwebsockets.inc

SRC_URI = "http://git.libwebsockets.org/cgi-bin/cgit/libwebsockets/snapshot/libwebsockets-1.4-chrome43-firefox-36.tar.gz"
SRC_URI[md5sum] = "0452c278a5cd4349135df2a693f35c28"
SRC_URI[sha256sum] = "e11492477e582ef0b1a6ea2f18d81a9619b449170a3a5c43f32a9468461a9798"

S = "${WORKDIR}/libwebsockets-1.4-chrome43-firefox-36"
