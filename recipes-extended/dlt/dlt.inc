DESCRIPTION = "GENIVI Diagnostic Log and Trace"
HOMEPAGE = "http://projects.genivi.org/diagnostic-log-trace/home"
SECTION = "net"
LICENSE = "MPL-2.0"

inherit cmake pkgconfig gzipnative

DEPENDS = "zlib dbus"

SRC_URI = "git://git.projects.genivi.org/dlt-daemon.git"
S = "${WORKDIR}/git"

LIC_FILES_CHKSUM ??= "\
	file://COPYING;md5=622a594c0d02e14c1a46e9b6e9b096cd \
	file://LICENSE;md5=e879eaad64aab8e1f8e63e298f5cea28 \
"

inherit cmake

# We build minimal configuration (with or without systemd) by default
PACKAGECONFIG ??= 'examples man tests ${@ "systemd" if 'systemd' in '${DISTRO_FEATURES}' else ""}'
PACKAGECONFIG[systemd]  = "-DWITH_SYSTEMD=ON -DWITH_SYSTEMD_JOURNAL=ON,-DWITH_SYSTEMD=OFF,systemd"
#PACKAGECONFIG[doc] 	= "-DWITH_DOC=ON,-DWITH_DOC=OFF,"
PACKAGECONFIG[man] 	= "-DWITH_MAN=ON,-DWITH_MAN=OFF,gzip-native"
PACKAGECONFIG[examples]	= "-DWITH_EXAMPLES=ON,-DWITH_EXAMPLES=OFF,"
PACKAGECONFIG[tests]	= "-DWITH_TESTS=ON,-DWITH_TESTS=OFF,"

EXTRA_OECMAKE_append = " -DWITH_DOC=OFF -DWITH_MAN=OFF" 

PACKAGE_BEFORE_PN += "lib${PN} ${PN}-daemon ${PN}-test ${PN}-tools ${PN}-examples"
RDEPENDS_${PN}-dev += "lib${PN}"
RDEPENDS_${PN}-daemon += "lib${PN}"
RDEPENDS_${PN}-tools += "lib${PN}"

FILES_${PN}-dev = " \
	/usr/lib/*.so \
	/usr/include/dlt/* \
	/usr/lib/pkgconfig/*.pc \
"

FILES_lib${PN} = "\
	/usr/lib/*.so.* \
"

FILES_${PN}-daemon = "\
	/usr/bin/dlt-daemon \
	/usr/lib/systemd/system/dlt.service \
	/etc/dlt.conf \
"
CONFFILES_${PN}-daemon = "\
	/etc/dlt.conf \
"

FILES_${PN}-test = "\
	/usr/bin/dlt-test* \
	/usr/share/dlt-filetransfer \
"

FILES_${PN}-tools = "\
	/usr/bin/dlt-adaptor* \
	/usr/bin/dlt-control \
	/usr/bin/dlt-convert \
	/usr/bin/dlt-dbus \
	/usr/bin/dlt-receive \
	/usr/bin/dlt-system \
	/usr/lib/systemd/system/dlt-adaptor-udp.service \
	/usr/lib/systemd/system/dlt-receive.service \
	/usr/lib/systemd/system/dlt-system.service \
	/usr/lib/systemd/system/dlt-dbus.service \
	/etc/dlt-system.conf \
	/etc/dlt-dbus.conf \
"
CONFFILES_${PN}-tools = "\
	/etc/dlt-system.conf \
	/etc/dlt-dbus.conf \
"

FILES_${PN}-examples = "\
	/usr/bin/dlt-example* \
"


#pkg_postinst_libdlt() {
#    #!/bin/sh -e
#
#    [ "x$D" == "x" ] && ldconfig
#}

#pkg_postrm_libdlt() {
#    #!/bin/sh -e
#
#    [ "x$D" == "x" ] && ldconfig
#}

BBCLASSEXTEND += " native "
