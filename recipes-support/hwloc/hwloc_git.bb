require ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=79179bb373cd55cbd834463a514fb714"

SRC_URI = "git://github.com/open-mpi/hwloc.git;protocol=https"
SRCREV = "594b40fecc0061a8b310701d473e9f31995e92f0"
PV = "1.11.2+git"

S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "-1"

