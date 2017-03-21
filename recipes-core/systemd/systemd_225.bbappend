FILESEXTRAPATHS_append := '${THISDIR}/${PN}:'

PACKAGECONFIG += " networkd resolved "

SRC_URI += "file://eth0.network \
	    file://dummy0.network"

FILES_${PN} += "${sysconfdir}/systemd/network/*"
 
USERADD_PARAM_${PN} += "; --system systemd-network "

do_install_append() {

    install -d ${D}${sysconfdir}/systemd/network/

    install -m 0644 ${WORKDIR}/*.network  ${D}${sysconfdir}/systemd/network/
}

PR="r2"
