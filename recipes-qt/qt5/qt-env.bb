SUMMARY = "Setup enviropment for QT"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = " \
     file://qt \
     file://qt.sh \
"

S = "${WORKDIR}"

do_install() {
     install -d ${D}${sysconfdir}
     install -d ${D}${sysconfdir}/default
     install -d ${D}${sysconfdir}/profile.d

     install -m 644 ${S}/qt ${D}${sysconfdir}/default/
     install -m 644 ${S}/qt.sh ${D}${sysconfdir}/profile.d/
}
