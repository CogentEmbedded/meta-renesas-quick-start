FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_lager = "file://libpvrWAYLAND_WSEGL.so"
SRC_URI_append_stout = "file://libpvrWAYLAND_WSEGL.so"
SRC_URI_append_silk = "file://libpvrPVR2D_WAYLANDWSEGL.so"
SRC_URI_append_alt = "file://libpvrPVR2D_WAYLANDWSEGL.so"
SRC_URI_append_koelsch = "file://libpvrPVR2D_WAYLANDWSEGL.so"
SRC_URI_append_porter = "file://libpvrPVR2D_WAYLANDWSEGL.so"

do_install_append() {
    ln -s libGLESv2.so ${D}/usr/lib/libGLESv2.so.2 
}

do_install_append_lager() {
    install -m 644 ${WORKDIR}/libpvrWAYLAND_WSEGL.so ${D}/usr/lib/
} 

do_install_append_stout() {
    install -m 644 ${WORKDIR}/libpvrWAYLAND_WSEGL.so ${D}/usr/lib/
} 

do_install_append_silk() {
    install -m 644 ${WORKDIR}/libpvrPVR2D_WAYLANDWSEGL.so ${D}/usr/lib/
} 

do_install_append_alt() {
    install -m 644 ${WORKDIR}/libpvrPVR2D_WAYLANDWSEGL.so ${D}/usr/lib/
} 

do_install_append_koelsch() {
    install -m 644 ${WORKDIR}/libpvrPVR2D_WAYLANDWSEGL.so ${D}/usr/lib/
} 

do_install_append_porter() {
    install -m 644 ${WORKDIR}/libpvrPVR2D_WAYLANDWSEGL.so ${D}/usr/lib/
} 


