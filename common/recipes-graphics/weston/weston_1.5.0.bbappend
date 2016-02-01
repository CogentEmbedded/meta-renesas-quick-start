require meta-rcar-gen2/include/gles-control.inc

PATCHTOOL_rcar-gen2 = "git"

FILESEXTRAPATHS_prepend := '${THISDIR}/patches:'
FILESEXTRAPATHS_prepend := '${THISDIR}/files:'

SRC_URI_append = " \
    file://0001-desktop-shell-add-option-to-avoid-creating-the-panel.patch \
    file://0001-Share-toytoolkit-lib.patch \
    file://0002-Add-non-blocking-display_poll-routine-to-dispatch-ev.patch \
    file://0003-libtoytoolkit-rename-header-window.h-toytoolkit.h.patch \
    file://0006-vsp-renderer-crash-warkaround.patch \
    file://0007-notify-client-immediately-on-buffer-release.patch \
    file://0008-window.c-do-not-resize-if-not-needed.patch \
    file://0017-Fixed-memory-corruption-when-focus-listener-is-moved.patch \
    file://0018-Added-public-API-to-set-output-for-window.patch \
    file://0019-Fixed-display_poll-implementation.patch \
"



FILES_${PN}-dev += "${libdir}/libweston-toytoolkit*"
