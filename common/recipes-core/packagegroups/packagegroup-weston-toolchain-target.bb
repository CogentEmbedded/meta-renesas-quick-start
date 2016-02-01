DESCRIPTION = "Target packages for weston SDK"
LICENSE = "GPL"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

# Qt5 is included if listed in DISTRO_FEATURES
RDEPENDS_${PN} += "\
    packagegroup-common \
    packagegroup-qt5 \
    packagegroup-opencv-sdk \
    packagegroup-ptp \
"
