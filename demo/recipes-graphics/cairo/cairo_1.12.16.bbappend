require meta-rcar-gen2/include/gles-control.inc

PACKAGECONFIG_append = "${@' egl glesv2' if '${USE_GLES_WAYLAND}' == '1'  else ''}"
