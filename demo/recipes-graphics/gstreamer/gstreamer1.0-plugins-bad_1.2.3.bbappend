FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://split-waylandsink.patch \
    file://0001-gst-plugins-bad-waylandsink-Add-set-window-position-.patch \
    file://0002-gst-plugins-bad-waylandsink-tmpFix-Output-to-HDMI-an.patch \
    file://0003-gst-plugins-bad-waylandsink-Add-update-window-position-.patch \
    file://0004-gst-plugins-bad-waylandsink-Add-set-window-scale-.patch \
    file://0005-gst-plugins-bad-waylandsink-Update-plexible-set-window-scale-.patch \
    file://0006-Add-wayland-fullscreen-sink-base-standard-waylandsin.patch \
    file://0007-Add-gobject-properties-for-fullscreen-and-display-nu.patch \
    file://0008-wayland-sink-Update-to-1.7.0.patch \
    file://0009-Fixed-memory-leaks-found-by-Valgrind.wayland.patch \
    file://0010-Fixed-memory-leaks-found-by-Valgrind.waylandfs.patch \
"

SRCREV_rcar-gen2 = "07015d9ba6f53d4e08a3623a6d8d9466faff139c"
