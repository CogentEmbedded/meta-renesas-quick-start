FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI_append = " \
    file://0002-Fixed-bad-unlocking-in-pulsesink.patch \
"
