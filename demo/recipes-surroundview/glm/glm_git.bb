require glm.inc

SRC_URI = "\
	git://github.com/g-truc/glm.git \
	file://0001-Fix-cmake-pathes.patch \
"

SRCREV = "ebdd48fa6f4a3f1436badeb43580a7910551740e"
S = "${WORKDIR}/git"

PV = "0.999+git${SRCREV}"

DEFAULT_PREFERENCE = "-1"
