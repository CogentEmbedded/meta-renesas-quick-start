DESCRIPTION = "Demo package"
LICENSE = "GPL"

inherit packagegroup

PACKAGES = " \
	packagegroup-common \
	packagegroup-qt5 \
	packagegroup-opencv-sdk \
	packagegroup-surroundview \
	packagegroup-ptp \
	packagegroup-perf-test \
"

AVB_RDEPENDS=" \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-mpegtsmux \
    gstreamer1.0-libav \
    libmad \
    gstreamer1.0-plugins-ugly-mad \
"

RDEPENDS_packagegroup-common = "\
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-tune2fs \
    i2c-tools \
    openssl \
    socat \
    strace \
    ncurses \
    libudev \
    cpufrequtils \
    tcpdump libpcap \
    bash \
    eglibc-utils \
    ldd \
    procps \
    vim \
    iproute2 \
    htop \
    mc \
    v4l-utils \
    libcomerr \
    libe2p \
    libext2fs \
    libss \
    dbus \
    mm-init \
    can-utils libsocketcan \
    libgstapp-1.0 \
    gstreamer1.0-plugins-base-app \
    udev-rules \
    netevent \
    ${AVB_RDEPENDS} \
"

RDEPENDS_packagegroup-qt5 =  '${@ " \
    qtbase-fonts \
    qtbase-plugins \
    qtbase-examples \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtxmlpatterns \
    qtxmlpatterns-examples \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsvg \
    qtsvg-plugins \
    qtwayland \
    qtwayland-tools \
    qtwayland-plugins \ 
    icu libicudata libicuuc libicui18n \
" if 'qt5' in '${DISTRO_FEATURES}' else ""}'


RDEPENDS_packagegroup-surroundview = '${@ " \
    spacenavd \
    libspnav \
    glm \
    nlopt \
" if 'surroundview' in '${DISTRO_FEATURES}' else ""}'

RDEPENDS_packagegroup-opencv-sdk = '${@ " \
    opencv \
    opencv-apps \
    opencv-samples \
    opencv-dbg \
    opencv-staticdev \
    python-opencv \
    libopencv-calib3d \
    libopencv-contrib \
    libopencv-core \
    libopencv-features2d \
    libopencv-flann \
    libopencv-gpu \
    libopencv-highgui \
    libopencv-imgproc \
    libopencv-legacy \
    libopencv-ml \
    libopencv-nonfree \
    libopencv-objdetect \
    libopencv-photo \
    libopencv-stitching \
    libopencv-superres \
    libopencv-video \
    libopencv-videostab \
    libopencv-ocl  \
    gstreamer1.0-plugins-base-app \
" if 'opencv-sdk' in '${DISTRO_FEATURES}' else ""}'

RDEPENDS_packagegroup-ptp =  '${@ " \
	linuxptp \
" if 'ptp' in '${DISTRO_FEATURES}' else ""}'

RDEPENDS_packagegroup-perf-test = '${@ " \
    glmark2 \
    iperf \
    cpuburn-neon \
" if 'perf-test' in '${DISTRO_FEATURES}' else ""}'
