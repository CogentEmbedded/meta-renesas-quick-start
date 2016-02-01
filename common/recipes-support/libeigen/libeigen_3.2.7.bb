DESCRIPTION = "Eigen is a C++ template library for linear algebra: matrices, vectors, numerical solvers, and related algorithms."
AUTHOR = "Benoît Jacob and Gaël Guennebaud and others"
HOMEPAGE = "http://eigen.tuxfamily.org/"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING.MPL2;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "http://bitbucket.org/eigen/eigen/get/${PV}.tar.bz2 \
           file://0001-CMakeLists.txt-install-FindEigen3.cmake-script.patch"
SRC_URI[md5sum] = "cc1bacbad97558b97da6b77c9644f184"
SRC_URI[sha256sum] = "e58e1a11b23cf2754e32b3c5990f318a8461a3613c7acbf6035870daa45c2f3e"

S = "${WORKDIR}/eigen-eigen"

# bitbucket packs source code in a sub-directory with commit Id suffix.  We have to harmonize that
do_unify_sources(){
	S_bitbucket=$(find '${WORKDIR}' -maxdepth 1 -name 'eigen-eigen-*' -type d -print)
	find "${S_bitbucket}" -maxdepth 1 ! -path "${S_bitbucket}" -exec cp -r {} '${S}' \; -print
}
addtask unify_sources after do_unpack before do_patch

inherit cmake

EXTRA_OECMAKE += "-Dpkg_config_libdir=${libdir}"

FILES_${PN} = "${includedir} ${libdir}"
FILES_${PN}-dev = "${datadir}/cmake/Modules"

# ${PN} is empty so we need to tweak -dev and -dbg package dependencies
RDEPENDS_${PN}-dev = ""
RRECOMMENDS_${PN}-dbg = "${PN}-dev (= ${EXTENDPKGV})"
