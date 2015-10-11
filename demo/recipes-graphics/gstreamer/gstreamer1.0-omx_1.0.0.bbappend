FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0002-omx-videodec-add-planebuf-to-allocation-request.patch \
    file://0003-Fixed-memory-corruption-and-bad-access.patch \
"
