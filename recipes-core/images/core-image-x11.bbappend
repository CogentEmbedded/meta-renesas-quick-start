IMAGE_INSTALL_append = " \
	packagegroup-common \
	packagegroup-qt5 \
	packagegroup-opencv-sdk \
	packagegroup-surroundview \
	packagegroup-ptp \
	packagegroup-perf-test \
"

CONFLICT_DISTRO_FEATURES = "wayland"

ROOTFS_POSTPROCESS_COMMAND += "do_rewrite_init;"

do_rewrite_init() {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        cd ${WORKDIR}/rootfs/sbin

        # Replace init process link
        ln -sf init.sysvinit init
    fi
}
