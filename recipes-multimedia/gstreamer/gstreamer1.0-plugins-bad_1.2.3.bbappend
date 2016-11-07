FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

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
    file://0014-Update-waylandsink-to-1.4.5.patch \
    file://0015-Add-wayland-lib.patch \
    file://0016-Add-allocation-from-DRM.patch \
    file://0017-Define-wayland-buffer-count-in-h-file.patch \
    file://0018-Replace-old-buffer-with-new-if-old-one-was-not-rende.patch \
    file://0019-Check-KMS-buffer-format-commented-out.patch \
    file://0020-Add-format-debug.patch \
    file://0021-wayland-install-.pc-file.patch \
    file://0022-Install-header.patch \
    file://0023-Avoid-double-rendering-of-the-same-buffer.patch \
    file://0024-Do-not-create-shm-pool-if-we-use-kms.patch \
    file://0025-Destroy-kms-on-finalize.patch \
    file://0026-Remove-buffer-from-hush-table-whet-freeing-wl-meta.patch \
    file://0027-Fix-creating-wl-buffers-from-dma-buffers-direct-omx-.patch \
    file://0028-Fix-format-checking-when-using-VSP-renderer.patch \
    file://0029-Fix-debug-output.patch \
    file://0030-GStreamer-tsdemux-add-WiFi-display-LPCM-format-suppo.patch \
    file://0031-tsdemux-do-not-discard-on-discont-if-PES-start.patch \
    file://0032-Use-timeout-on-wayland-display-poll.patch \
    file://0033-Unref-dangling-reference-to-display.patch \
"

SRCREV_rcar-gen2 = "07015d9ba6f53d4e08a3623a6d8d9466faff139c"
