
FILESEXTRAPATHS_prepend := '${THISDIR}/${PN}-${PV}:'

SRC_URI_append = " \
    file://0001-Share-toytoolkit-lib.patch \
    file://0002-add-window-set-fullscreen-at-output.patch \
    file://0003-add-display-poll-func.patch \
    file://0004-Add-wl-shell-simulator-support.patch \
    file://0005-Add-gst-recorder-virtual-displays.patch \
"

EXTRA_OECONF += "--enable-gst-recorder "
DEPENDS += "media-ctl"

PR="r2"

FILES_${PN} += " ${libdir}/libweston-toytoolkit*"


