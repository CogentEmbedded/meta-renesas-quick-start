DESCRIPTION = "Demo package"
LICENSE = "GPL"

inherit packagegroup

PACKAGES = " \
    packagegroup-common \
    packagegroup-qt \
    packagegroup-opencv \
    packagegroup-surroundview \
"

RDEPENDS_packagegroup-common = " \
    mm-init \
    udev-rules \    
"


RDEPENDS_packagegroup-qt = " \
    qtbase-fonts \
    qtbase-plugins \
    qtbase-tools \
    qtbase-examples \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsvg \
    qtsvg-plugins \
    qtimageformats-plugins \
    qtwebkit \
    qtwebkit-qmlplugins \
    qtwebkit-examples-examples \
    qtwayland \
    qtwayland-tools \
    qtwayland-plugins \ 
    qtwayland-examples \
    qtwebengine \
    qtwebengine-examples \
    qtwebengine-qmlplugins \
    icu libicudata libicuuc libicui18n \
"

RDEPENDS_packagegroup-opencv = " \
    opencv-apps \
    opencv \
    opencv-samples \
    gstreamer1.0-plugins-base-app \
"

AVB_RDEPENDS=" \
    libpcap \
    tcpdump \
    iperf \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-mpegtsmux \
    gstreamer1.0-libav \
    libmad \
    gstreamer1.0-plugins-ugly-mad \
"

RDEPENDS_packagegroup-surroundview = " \
    opencv \
    libopencv-core \
    libopencv-highgui \
    libopencv-imgproc \
    libopencv-features2d \
    libopencv-calib3d \
    libopencv-flann \
    spacenavd \
    libspnav \
    ${AVB_RDEPENDS} \
"
