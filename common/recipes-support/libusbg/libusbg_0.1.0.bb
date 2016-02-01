require libusbg.inc

SRC_URI = "https://github.com/libusbg/libusbg/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "2d3af961f7007a35ed3816de6b712ac1"
SRC_URI[sha256sum] = "82fa5c71741a70477148ed455c307611075a4f9af6886ab3e7a4471377dfd2c7"

S = "${WORKDIR}/libusbg-${PV}"

