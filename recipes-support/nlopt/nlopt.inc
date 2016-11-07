DESCRIPTION = "library for nonlinear optimization, wrapping many algorithms for global and local, constrained or unconstrained, optimization"
HOMEPAGE = "http://ab-initio.mit.edu/wiki/index.php/NLopt"
SECTION = "System/Libraries"
LICENSE = "LGPL-2.1 | MIT"

LIC_FILES_CHKSUM ??= "file://COPYING;md5=7036bf07f719818948a837064b1af213"

inherit autotools pkgconfig

DEPENDS += "swig-native"

# remove dead weight from the build
EXTRA_OECONF += " \
	--without-guile \
	--without-python \
	--without-octave \
	--without-matlab \
	--enable-shared \
"

# see https://github.com/stevengj/nlopt/issues/29
EXTRA_OECONF += "--enable-maintainer-mode"

# see https://github.com/stevengj/nlopt/issues/9
do_configure_prepend () {
	touch ${S}/swig/nlopt.scm.in
}

SRC_URI_append = " file://0001-Fix-compilation-error.patch"

