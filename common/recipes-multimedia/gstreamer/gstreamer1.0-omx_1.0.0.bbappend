FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://gstomx.conf \
    file://0002-omx-videodec-add-planebuf-to-allocation-request.patch \
    file://0003-Fixed-memory-corruption-and-bad-access.patch \
"

# ...disable offset between planes in semi-planar formats
EXTRA_OECONF_append_rcar-gen2 = " --disable-nv12-page-alignment"

# ...install OMX configuration
do_install_append() {
	install -d ${D}/etc/xdg
	install -m644 ${WORKDIR}/gstomx.conf ${D}/etc/xdg/gstomx.conf
}
