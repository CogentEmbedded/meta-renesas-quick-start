FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# switch to GLES 2 support
PACKAGECONFIG_GL = "${@base_contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"

# add necessary packages
PACKAGECONFIG_append = " \
	sql-sqlite \
	sql-sqlite2 \
	openssl \
	icu \
	accessibility \
	examples \
	alsa \
	glib \
"

DEPENDS += "gles-user-module"
