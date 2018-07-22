FILESEXTRAPATHS_append := "${@base_contains('DISTRO_FEATURES', 'wayland','${THISDIR}/qtwayland:','',d)}"
SRC_URI_append = "${@base_contains('DISTRO_FEATURES', 'wayland','file://0001-remove-xcomposite-and-drm.patch','',d)} \
                  file://0002-qtwayland_select_screen.patch \
"

DEPENDS_append = "  gles-user-module"
