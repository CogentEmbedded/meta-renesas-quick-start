require libwebsockets.inc

SRC_URI = "http://git.libwebsockets.org/cgi-bin/cgit/libwebsockets/snapshot/libwebsockets-1.23-chrome32-firefox24.tar.gz"
SRC_URI[md5sum] = "b39c559c62192128bf4c3d8eedd992a8"
SRC_URI[sha256sum] = "8d94a75ed1b69571d251e79512a424de51a411bafd57a66ccbe690b560a41359"

S = "${WORKDIR}/libwebsockets-1.23-chrome32-firefox24"

# prefer it by default for automotive-message-broker
DEFAULT_PREFERENCE = "2"
