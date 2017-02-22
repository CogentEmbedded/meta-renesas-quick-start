FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${LINUX_VERSION}:"

SRC_URI_append_salvator-x = "\
     file://touch_multi.cfg \
     file://can.cfg \
"
SRC_URI_append_h3ulcb = "\
     file://touch_multi.cfg \
     file://can.cfg \
"

SRC_URI_append_wheat = "\
    file://touch_multi.cfg \
"

SRC_URI_append_ttardrive = "\
     file://touch_multi.cfg \
"
