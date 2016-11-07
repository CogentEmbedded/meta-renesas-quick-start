FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "707d10f11526afee1e1a35ec7fdaa8b05f7e1656"
PV = "2.4.11+git${SRCPV}"

SRC_URI += "file://0001-make-demo.patch"

