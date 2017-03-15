DESCRIPTION = "yaml-cpp is a YAML parser and emitter in C++ matching the YAML 1.2 spec"
HOMEPAGE = "https://github.com/jbeder/yaml-cpp/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a8aaf0595c2efc1a9c2e0913e9c1a2c"

DEPENDS = "boost"

PR = "r0"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/jbeder/yaml-cpp.git"
SRCREV = "bedb28fdb4fd52d97e02f6cb946cae631037089e"

# pkgconfig is enough
do_install_append() {
    rm -r ${D}${libdir}/cmake
}

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"

inherit cmake