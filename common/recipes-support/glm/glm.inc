SUMMARY = "OpenGL Mathematics"
HOMEPAGE = "http://glm.g-truc.net"
DESCRIPTION = "OpenGL Mathematics (GLM) is a header only C++ mathematics library for graphics software based on the OpenGL Shading Language (GLSL) specifications."
LICENSE = "MIT"
SECTION = "multimedia"

inherit pkgconfig cmake

LIC_FILES_CHKSUM = " \
	file://copying.txt;md5=6ba02d5f908587c6f3942e76bf6d92d6 \
"

ALLOW_EMPTY_${PN} = "1"

FILES_${PN}-dev += "/usr/lib/cmake/"

