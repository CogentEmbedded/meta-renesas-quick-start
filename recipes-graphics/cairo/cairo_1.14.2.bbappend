require include/gles-control.inc

PACKAGECONFIG_pn-cairo_append = "${@' egl glesv2' if '${USE_GLES_WAYLAND}' == '1'  else ''}"
PACKAGECONFIG_pn-cairo_append += "${@bb.utils.contains('DISTRO_FEATURES', 'directfb', 'directfb', '', d)}"
