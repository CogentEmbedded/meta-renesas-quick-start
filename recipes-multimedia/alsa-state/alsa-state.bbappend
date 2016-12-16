FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI_append = " \
    file://asound.conf \
    file://asound.state \
"

do_install_append() {
    cp -a ${WORKDIR}/asound.conf ${D}/etc/asound.conf
    cp -a ${WORKDIR}/asound.state ${D}/var/lib/alsa/asound.state
}

