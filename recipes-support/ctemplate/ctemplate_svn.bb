require ctemplate.inc

SRC_URI = "svn://ctemplate.googlecode.com/svn/;module=trunk;protocol=http"
SRC_URI[md5sum] = ""
SRC_URI[sha256sum] = ""
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/trunk"

PV = "2.3+svnr${SRCREV}"

DEFAULT_PREFERENCE = "-1"
