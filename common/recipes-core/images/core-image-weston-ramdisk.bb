SUMMARY = "A small image capable of running Weston."

IMAGE_INSTALL = " \
	packagegroup-core-boot \
	${ROOTFS_PKGMANAGE_BOOTSTRAP} \
	${CORE_IMAGE_EXTRA_INSTALL} \
	packagegroup-common \
	packagegroup-qt5 \
	packagegroup-opencv-sdk \
	packagegroup-surroundview \
	packagegroup-ptp \
	packagegroup-perf-test \
	packagegroup-rcar-gen2-multimedia \
"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs ssh-server-openssh"

#IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image distro_features_check


REQUIRED_DISTRO_FEATURES = "wayland"

IMAGE_CLASSES = "image_types_uboot"

inherit image_types_uboot

IMAGE_FSTYPES = "cpio.gz.u-boot"

CONFLICT_DISTRO_FEATURES = "x11"

ROOTFS_POSTPROCESS_COMMAND += "do_rewrite_init;"

do_rewrite_init() {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        cd ${WORKDIR}/rootfs/sbin

        # Replace init process link
        ln -sf init.sysvinit init
    fi

    ln -s /sbin/init ${WORKDIR}/rootfs/init
}


IMAGE_INSTALL_append_rcar-gen2 = " \
    v4l-utils \
    gstreamer1.0-omx \
    omx-user-module \
    iperf \
    tcpdump \
    libpcap \
    gstreamer1.0-plugins-base-vspfilter \
    gstreamer1.0-plugins-base-videorate \
    gstreamer1.0-plugins-base-videotestsrc \
    gstreamer1.0-plugins-base-videoscale \
    gstreamer1.0-plugins-base-videorate \
    gstreamer1.0-plugins-base-videoconvert \
    gstreamer1.0-plugins-base-audiotestsrc \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-video4linux2 \
    gstreamer1.0-plugins-good-videocrop \
    gstreamer1.0-plugins-bad-asfmux \
    gstreamer1.0-plugins-bad-fbdevsink \
    gstreamer1.0-plugins-bad-faad \
    gstreamer1.0-plugins-bad-videoparsersbad \
    ntp \
    ntp-utils \
    libspnav \
    libegl \
    wayland \
    zlib \
    cairo \
    weston \
    weston-init weston-examples	\
    gles-user-module \
    gles-kernel-module \
"

IMAGE_INSTALL_append_lcb = " \
    can-utils \
    libsocketcan \
    iproute2 \
    mtd-utils \
    mtd-utils-jffs2 \
"

# common
IMAGE_INSTALL_append = " \
	alsa-utils alsa-tools \
	libdrm-tests \
	libdrm-kms \
	bash \
	perf \
"

# For GStreamer 
# need commercial plugins
def map_gst_commercial(d):
    install_list = ""
    if base_contains('LICENSE_FLAGS_WHITELIST', 'commercial', "1", "0", d) == "1":
        if base_contains('USE_GSTREAMER_0_10', '1', "1", "0", d) == "1":
            install_list += " gst-plugins-ugly gst-plugins-ugly-asf gst-openmax"
        if base_contains('USE_GSTREAMER_1_00', '1', "1", "0", d) == "1":
            install_list += " gstreamer1.0-plugins-ugly-asf gstreamer1.0-omx"
    return install_list

IMAGE_INSTALL_append = "${@map_gst_commercial(d)}"

# gstreamer 0.10 plugins
IMAGE_INSTALL_append = ' ${@base_contains("USE_GSTREAMER_0_10", "1", " \
	gst-plugins-base-videorate \
	gst-plugins-base-videotestsrc \
	gst-plugins-good \
	gst-plugins-good-isomp4 \
	gst-plugins-good-video4linux2 \
	gst-plugins-good-videocrop \
	gst-plugins-good-audioparsers \
	gst-plugins-bad \
	gst-plugins-bad-asfmux \
	gst-plugins-bad-fbdevsink \
	gst-plugins-bad-h264parse \
	gst-plugins-bad-faad \
	gst-plugins-bad-videoparsersbad \
	", "", d)}'

# gstreamer 1.0 plugins
IMAGE_INSTALL_append = ' ${@base_contains("USE_GSTREAMER_1_00", "1", " \
	gstreamer1.0-plugins-base-videorate \
	gstreamer1.0-plugins-base-videotestsrc \
	gstreamer1.0-plugins-base-audiotestsrc \
	gstreamer1.0-plugins-base-alsa \
	gstreamer1.0-plugins-good-autodetect \
	gstreamer1.0-plugins-good-isomp4 \
	gstreamer1.0-plugins-good-video4linux2 \
	gstreamer1.0-plugins-good-videocrop \
	gstreamer1.0-plugins-bad-asfmux \
	gstreamer1.0-plugins-bad-fbdevsink \
	gstreamer1.0-plugins-bad-faad \
	gstreamer1.0-plugins-bad-videoparsersbad \
	", "", d)}'

# for Middle software
CHECK_OMXIL_SH_MW = "${USE_RENESAS_MW_VCP1}"
CHECK_OMXIL_SH_MW += "${USE_RENESAS_MW_VPU5}"
IMAGE_INSTALL_append_armadillo800eva = ' ${@base_contains("CHECK_OMXIL_SH_MW", "1", "omxil-sh", "", d)} \
	gst-plugins-bad-dfbvideosink \	
	v4l-utils \
	libshvio \
	libshmeram \
' 

# gstreamer 1.0 plugins. waylandsink plugin is provided in gstreamer 1.0 only.
IMAGE_INSTALL_append = ' ${@base_contains("USE_GSTREAMER_1_00", "1", " \
	gstreamer1.0-plugins-bad-waylandsink \
	", "", d)}'

IMAGE_INSTALL_append_rcar-gen2 = '${@base_contains("MACHINE_FEATURES", "rgx", \
	" gles-kernel-module libegl libegl-dev \
	libgbm-dev ldd", "", d)}'

IMAGE_INSTALL_append_rcar-gen2 = '${@base_contains("MACHINE_FEATURES", "sgx", \
	" gles-kernel-module libegl libegl-dev \
	libgbm-dev ldd", "", d)}'

toolchain_shared_env_script_append() {
    cat >> $script <<EOF
# Append environment subscripts
if [ -d "\$OECORE_TARGET_SYSROOT/environment-setup.d" ]; then
    for envfile in \$OECORE_TARGET_SYSROOT/environment-setup.d/*.sh; do
	    source \$envfile
    done
fi
if [ -d "\$OECORE_NATIVE_SYSROOT/environment-setup.d" ]; then
    for envfile in \$OECORE_NATIVE_SYSROOT/environment-setup.d/*.sh; do
	    source \$envfile
    done
fi
EOF
}