SUMMARY = "Bluetooth firmare files for WL18xx combo modules"
SECTION = "misc"

LICENSE = "CLOSED"

PE = "1"
PV = "0.0"

SRC_URI = "git://github.com/TI-ECS/bt-firmware.git;protocol=git "
SRCREV = "169b2df5b968f0ede32ea9044859942fc220c435"

S = "${WORKDIR}/git"

CLEANBROKEN = "1"

do_populate_lic[noexec] = "1"
do_compile[noexec] = "1"
do_configure[noexec] = "1"

do_install() {
	install -d  ${D}/lib/firmware/
	cp *.bts ${D}/lib/firmware/
}

FILES_${PN} = "/lib/firmware/*"