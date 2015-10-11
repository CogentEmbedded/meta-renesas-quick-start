FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://0001-evdev-notify-touch-frame-on-EV_SYN-event.patch \
"