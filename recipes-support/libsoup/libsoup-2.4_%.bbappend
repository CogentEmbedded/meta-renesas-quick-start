FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# libsoup-gnome is entirely deprecated, disable it
PACKAGECONFIG = ""

SRC_URI_append = " \
	file://0001-Parse-requests-with-any-HTTP-compatible-protocols-li.patch \
	file://0001-Add-parsing-of-invalid-IPv6-address-specification-in.patch \
"
