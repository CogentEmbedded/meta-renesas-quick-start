SUMMARY = "Tools for si46xx AM/FM/DAB radio chip"
SECTION = "multimedia"

LICENSE = "CLOSED"

PE = "1"
PV = "0.2"

SRC_URI = " \
	file://si-tools.tar.gz \
	file://si_init \
	file://si_firmware_update \
"

S = "${WORKDIR}/si-tools"

do_install() {
	install -d ${D}${bindir}

	install -m 0755 si_ctl ${D}${bindir}
	install -m 0755 si_flash ${D}${bindir}
	install -m 0755 ${WORKDIR}/si_init ${D}${bindir}
	install -m 0755 ${WORKDIR}/si_firmware_update ${D}${bindir}
}