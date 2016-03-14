DESCRIPTION = "OpenCL ICD Loader"
HOMEPAGE = "https://forge.imag.fr/projects/ocl-icd/"
LICENSE = "BSD"
SECTION = "libs/misc"

inherit autotools

DEPENDS += "ruby-native"
PROVIDES = "virtual/ocl-icd"

LIC_FILES_CHKSUM = "file://COPYING;md5=232257bbf7320320725ca9529d3782ab"

