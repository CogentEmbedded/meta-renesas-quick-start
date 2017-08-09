inherit ${@base_contains('DISTRO_FEATURES', 'qt5','populate_sdk_qt5',' ',d)}

IMAGE_INSTALL_append = " \
	packagegroup-common \
	packagegroup-qt5 \
	packagegroup-opencv-sdk \
	packagegroup-surroundview \
	packagegroup-ptp \
	packagegroup-perf-test \
	packagegroup-bt \
	packagegroup-wifi \
	packagegroup-radio \
"

CONFLICT_DISTRO_FEATURES = "x11"
