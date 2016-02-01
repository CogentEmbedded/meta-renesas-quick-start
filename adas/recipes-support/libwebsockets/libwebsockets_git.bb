require libwebsockets.inc

# get master from git
SRC_URI = "git://git.libwebsockets.org/libwebsockets"
S = "${WORKDIR}/git"
SRCREV = "3ae1badae7a05e0982e0dfbcb078da3d4b92a81d"

DEFAULT_PREFERENCE = "-1"

