FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
 	       file://0001-Add-gbm_bo_get_fd-function.patch \
"