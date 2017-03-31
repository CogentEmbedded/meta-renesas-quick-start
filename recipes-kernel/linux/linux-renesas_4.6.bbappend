FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${LINUX_VERSION}:"

SRC_URI_append = "\
     file://cma.cfg \
"

SRC_URI_append_salvator-x = "\
     file://touch_multi.cfg \
     file://can.cfg \
"
SRC_URI_append_h3ulcb = "\
     file://touch_multi.cfg \
     file://can.cfg \
"

SRC_URI_append_m3ulcb = "\
     file://touch_multi.cfg \
     file://can.cfg \
"

SRC_URI_append_wheat = "\
    file://touch_multi.cfg \
"

SRC_URI_append_ttardrive = "\
     file://touch_multi.cfg \
"
# SRC_URI_append = " 
#      file://0001-workaround-fix-disable-warning-on-free_contig_page.patch 
#"