SUMMARY = "Demo videos and configuration for Surround View application"
HOMEPAGE = "http://cogentembedded.com"
LICENSE = "MIT"

SRC_URI = "https://www.dropbox.com/sh/d2tbmbaddgt6hkl/AAC4zoArsTKxzFMcNCoG5WX2a?dl=1;name=tarball"
SRC_URI[tarball.md5sum] = "29efae10de6b4e54523e70adc5990ead"
SRC_URI[tarball.sha256sum] = "d3189d325c789f4b61934581fb1af94646ad091be18b6c0cb75734c38182e083"
S = "${WORKDIR}/src"

do_unpack() {
	mkdir -p ${S}
	cd ${S}
	# Workaround a dropbox archive contanining "/" path which is impossible
	#   to extract without root permissions. Just ignore the error
	unzip "${DL_DIR}/AAC4zoArsTKxzFMcNCoG5WX2a?dl=1" || echo "Ok"
}

do_configure[noexec] = "1"
do_compile[noexec] = "1"

INSTALLDIR = "${datadir}/sv/demo"

do_install() {
	install -d ${D}${INSTALLDIR}
	install -m 644 ${S}/*.mkv ${D}${INSTALLDIR}
	install -m 644 ${S}/tracks.cfg ${D}${INSTALLDIR}
	install -m 644 ${S}/config*.xml ${D}${INSTALLDIR}
}

FILES_${PN} += "${INSTALLDIR}"
