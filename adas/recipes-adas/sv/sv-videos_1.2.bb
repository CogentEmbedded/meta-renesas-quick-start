SUMMARY = "Demo videos and configuration for Surround View application"
HOMEPAGE = "http://cogentembedded.com"
LICENSE = "MIT"

SRC_URI = "https://gitlab.com/cogentembedded/SurroundView-Goods/repository/archive.zip?ref=${PV};downloadfilename=archive.zip"
SRC_URI[md5sum] = "9a623cee79936312a74abce311c0241c"
SRC_URI[sha256sum] = "0b2c112b2d65b2287ddf1b200cd773a2ac6b260989deee25f1b85d21ea2929e7"
S = "${WORKDIR}/SurroundView-Goods"

# gitlab packs source code in a sub-directory with commit Id suffix.  We have to harmonize that
do_unify_sources(){
	S_gitlab=$(find '${WORKDIR}' -maxdepth 1 -name 'SurroundView-Goods-${PV}-*' -type d -print)
	find "${S_gitlab}" -maxdepth 1 ! -path "${S_gitlab}" -exec cp -r {} '${S}' \; -print
}
addtask unify_sources after do_unpack before do_patch

do_configure[noexec] = "1"
do_compile[noexec] = "1"

INSTALLDIR = "${datadir}/sv/default"

do_install() {
	install -d ${D}${INSTALLDIR}
	cd ${S}/videos-parking-srx
	cp -ra * ${D}${INSTALLDIR}
}
# The resulting package is quite large (100 MB+)

FILES_${PN} += "${INSTALLDIR}"
