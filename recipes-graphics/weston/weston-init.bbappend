FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://weston.ini \
	file://weston-env.sh \
"

# Add Weston configuration script
do_install_append() {
    install -d ${D}/etc/xdg/weston
    install -m 644 ${WORKDIR}/weston.ini ${D}/etc/xdg/weston/

    install -d ${D}/etc/profile.d
    install -m 0755 ${WORKDIR}/weston-env.sh ${D}/etc/profile.d
}
FILES_${PN} += " /etc/xdg/weston/weston.ini \
		 /etc/profile.d/weston-env.sh \
"
