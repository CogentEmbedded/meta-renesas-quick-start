DESCRIPTION = "Khronos OpenCL-Headers"
HOMEPAGE = "https://www.khronos.org/registry/cl/"
LICENSE = "MIT"
SECTION = "libs/misc"

LIC_FILES_CHKSUM = "file://opencl.h;beginline=1;endline=27;md5=b75d70d0f7cb3bb2bc8886141a84319e"
SRC_URI = "git://github.com/KhronosGroup/OpenCL-Headers.git;protocol=https;nobranch=1"
S = "${WORKDIR}/git"
STRIP_PV = "${@'${PV}'.replace('.','')}"
SRCREV = "opencl${STRIP_PV}"

PROVIDES = "virtual/ocl-headers"

do_configure() {
	# we check LIC_FILES_CHKSUM
	echo "Done"
}

do_compile[noexec] = "1"

do_install() {
	install -d ${D}${includedir}/CL
	cd ${S}
	# install all header files
	find . -name \*.h -print0 | xargs -0 -I{} install -m 644 {} ${D}${includedir}/CL
}

