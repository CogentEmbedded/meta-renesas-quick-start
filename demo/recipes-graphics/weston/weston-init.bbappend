FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = " \
	file://init \
	file://weston.ini \
	file://weston_exp.sh \
"

# Add Weston configuration script
do_install_append() {
    install -d ${D}/etc/xdg/weston
    install -m 644 ${WORKDIR}/weston.ini ${D}/etc/xdg/weston/

    install -d ${D}/etc/profile.d
    install -m 0755 ${WORKDIR}/weston_exp.sh ${D}/etc/profile.d
}
FILES_${PN} += " /etc/xdg/weston/weston.ini \
		 /etc/profile.d/weston_exp.sh \
"
