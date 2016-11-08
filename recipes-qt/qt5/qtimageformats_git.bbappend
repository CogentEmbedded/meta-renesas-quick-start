FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_rcar-gen3 = " \
        file://0001-fix-webp-pri-arm64-neon-tetection.patch \
"


