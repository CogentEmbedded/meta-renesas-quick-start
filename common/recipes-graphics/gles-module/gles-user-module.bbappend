FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_r8a7790 = "file://libpvrWAYLAND_WSEGL.so file://libGLESv2.so"
SRC_URI_append_r8a7794 = "file://libpvrPVR2D_WAYLANDWSEGL.so"
SRC_URI_append_r8a7791 = "file://libpvrPVR2D_WAYLANDWSEGL.so"

do_install_append() {
    ln -s libGLESv2.so ${D}/usr/lib/libGLESv2.so.2 
}

do_install_append_r8a7790() {
    install -m 644 ${WORKDIR}/libGLESv2.so ${D}/usr/lib/
    install -m 644 ${WORKDIR}/libpvrWAYLAND_WSEGL.so ${D}/usr/lib/
} 

do_install_append_r8a7794() {
    install -m 644 ${WORKDIR}/libpvrPVR2D_WAYLANDWSEGL.so ${D}/usr/lib/
} 

do_install_append_r8a7791() {
    install -m 644 ${WORKDIR}/libpvrPVR2D_WAYLANDWSEGL.so ${D}/usr/lib/
}
 
