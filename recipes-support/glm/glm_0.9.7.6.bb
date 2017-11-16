require glm.inc

SRC_URI = "\
	https://github.com/g-truc/${BPN}/archive/${PV}.tar.gz \
	file://0001-Fix-cmake-pathes.patch \
"

SRC_URI[md5sum] = "5b75955d21ce2c2d515919d30c69a3eb"
SRC_URI[sha256sum] = "872fdea580b69b752562adc60734d7472fd97d5724c4ead585564083deac3953"
