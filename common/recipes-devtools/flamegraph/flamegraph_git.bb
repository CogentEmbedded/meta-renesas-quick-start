require flamegraph.inc

inherit allarch

RDEPENDS_${PN} = "perl-module-getopt-long"
RRECOMMENDS_${PN} = "perf"

SRCREV = "921d598bf5811c36f1f17b31d15b07e19cd40d6f"
S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://${S}/flamegraph.pl;beginline=50;endline=67;md5=46d35353fb1db67618aefae312f20f0d"

do_install(){
	install -d ${D}/usr/share/${PN}/

	cp -a ${S}/* ${D}/usr/share/${PN}/
}

PACKAGES_prepend = "${PN}-demos "

FILES_${PN}-doc = "/usr/share/${PN}/docs/"

FILES_${PN}-demos = " \
	/usr/share/${PN}/demos/ \
	/usr/share/${PN}/example.svg \
	/usr/share/${PN}/example-stacks.txt \
"

FILES_${PN} = "/usr/share/${PN}/"

