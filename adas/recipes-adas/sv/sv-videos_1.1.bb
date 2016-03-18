SUMMARY = "Demo videos and configuration for Surround View application"
HOMEPAGE = "http://cogentembedded.com"
LICENSE = "MIT"

DROPBOX_FOLDERNAME = "o25jjaiuhf5aai5"
DROPBOX_FILENAME = "AABdX0iowCE8M6ehuZGV43m5a?dl=1"

SRC_URI = "https://www.dropbox.com/sh/${DROPBOX_FOLDERNAME}/${DROPBOX_FILENAME}"
SRC_URI[md5sum] = "a9d2078c71eb139ce19c4c4cd029e53b"
SRC_URI[sha256sum] = "e5d5ee1c9d2a3eca51ff0835845bfdb0d571e2bca34afda14c12334cb8ee6b34"
S = "${WORKDIR}/src"

do_unpack() {
	mkdir -p ${S}
	cd ${S}
	# Workaround a dropbox archive contanining "/" path which is impossible
	#   to extract without root permissions. Just ignore the error
	unzip "${DL_DIR}/${DROPBOX_FILENAME}" || echo "Ok"
}

do_configure[noexec] = "1"
do_compile[noexec] = "1"

INSTALLDIR = "${datadir}/sv/default"

do_install() {
	install -d ${D}${INSTALLDIR}
	install -m 644 ${S}/*.mkv ${D}${INSTALLDIR}
	install -m 644 ${S}/tracks.cfg ${D}${INSTALLDIR}
	install -m 644 ${S}/config*.xml ${D}${INSTALLDIR}
	install -m 644 ${S}/*.map ${D}${INSTALLDIR}

	install -d ${D}${INSTALLDIR}/calib
	install -m 644 ${S}/calib/* ${D}${INSTALLDIR}/calib
}
# The resulting package is quite large (100 MB+)

FILES_${PN} += "${INSTALLDIR}"
