require ${BPN}.inc

SRC_URI = "https://github.com/analogdevicesinc/${BPN}/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "4496c24dabdce60bdcf231ebe19bb501"
SRC_URI[sha256sum] = "c41cdcfeae8717e72f1100b4dac9d7cc9d86f4e0731da3354149cb7e051666f3"

LIC_FILES_CHKSUM ??= "file://COPYING;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"

S = "${WORKDIR}/${BPN}-${PV}"
