FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://updated-drivers.tar.bz2;name=update"

do_install_append() {
    ln -s libGLESv2.so ${D}/usr/lib/libGLESv2.so.2 

    # Install updated drivers when they are provided
    if [ "${GLES}" = "rgx" ]; then
	if [ -f "${WORKDIR}/updated-drivers/libGLESv2.so" ]; then
	    install -m 755 "${WORKDIR}/updated-drivers/libGLESv2.so" "${D}/usr/lib/"
	fi
	if [ -f "${WORKDIR}/updated-drivers/libpvrWAYLAND_WSEGL.so" ]; then
	    install -m 755 "${WORKDIR}/updated-drivers/libpvrWAYLAND_WSEGL.so" "${D}/usr/lib/"
	fi
    elif [ "${GLES}" = "sgx" ]; then
	if [ -f "${WORKDIR}/updated-drivers/libpvrPVR2D_WAYLANDWSEGL.so" ]; then
	    install -m 755 "${WORKDIR}/updated-drivers/libpvrPVR2D_WAYLANDWSEGL.so" "${D}/usr/lib/"
	fi
    fi
}

