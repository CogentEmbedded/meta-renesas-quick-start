require wpa-supplicant.inc

PR = "r1"

SRCREV = "eb2223e0ec1783a61af649171d3d2fc93cc56b09"
SRC_URI = "git://w1.fi/hostap.git;protocol=http \
           file://0001-Add-listen-stop-info-message.patch \
	   file://0002-Use-pkg-config-to-get-libnl3-paths.patch \
           file://defconfig-gnutls \
           file://wpa-supplicant.sh \
           file://wpa_supplicant.conf \
           file://wpa_supplicant.conf-sane \
           file://99_wpa_supplicant \
"

S = "${WORKDIR}/git"
