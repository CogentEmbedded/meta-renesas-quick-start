require include/gles-control.inc

DEPENDS_append_rcar-gen3 = " \
    ${@'libegl' if '${USE_GLES_WAYLAND}' == '1'  else ''}"

DEPENDS_append_rcar-gen3 = "${@bb.utils.contains("DISTRO_FEATURES", "x11", " libxdamage", "", d)}"

RDEPENDS_libcogl-pango_append_rcar-gen3 = " \
	${@bb.utils.contains("DISTRO_FEATURES", "x11", " libxdamage", "", d)}		\
	gdk-pixbuf \
"

RDEPENDS_libcogl-path_append_rcar-gen3 =  " \
	${@bb.utils.contains("DISTRO_FEATURES", "x11", " libxdamage", "", d)}		\
	gdk-pixbuf \
"
