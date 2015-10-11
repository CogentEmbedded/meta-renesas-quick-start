FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI_append = " \
    file://asound.conf \
"

do_install_append() {
    cp -a ${WORKDIR}/asound.conf ${D}/etc/asound.conf
}

