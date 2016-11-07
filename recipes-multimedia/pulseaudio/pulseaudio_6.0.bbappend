FILESEXTRAPATHS_append := "${THISDIR}/${PN}-${PV}:"

PR="r2"

SRC_URI_append_rcar-gen3 = " \
    file://pulseaudio.init \
    file://ak4613.conf \
    file://hifi \
    file://system.pa \
    file://daemon.conf \
"

inherit update-rc.d

INITSCRIPT_NAME = "pulseaudio"
INITSCRIPT_PARAMS = "defaults 30"

do_install_append_rcar-gen3() {
    install -d ${D}/etc/init.d
    install -d ${D}/etc/pulse
    install -d ${D}/usr/share/alsa/ucm/ak4613/

    install -m 0755 ${WORKDIR}/pulseaudio.init ${D}/etc/init.d/pulseaudio

    install -m 0644 ${WORKDIR}/system.pa ${D}/etc/pulse/system.pa
    install -m 0644 ${WORKDIR}/daemon.conf ${D}/etc/pulse/daemon.conf

    install -m 0644 ${WORKDIR}/ak4613.conf ${D}${datadir}/alsa/ucm/ak4613/ak4613.conf
    install -m 0644 ${WORKDIR}/hifi ${D}${datadir}/alsa/ucm/ak4613/hifi
    
}

FILES_${PN} += " \
	    ${datadir}/alsa/ucm \
"

