require ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=66a5f6f418ecccec4724869497edc415"

SRC_URI = "https://github.com/open-mpi/hwloc/archive/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "042d708f3b4d77f7b09e56430ce259b7"
SRC_URI[sha256sum] = "24eca023b33ef4fcb4e87363808dac3f26eb7a6012a1041fac4968ba0cc1f441"

S = "${WORKDIR}/${BPN}-${BPN}-${PV}"

