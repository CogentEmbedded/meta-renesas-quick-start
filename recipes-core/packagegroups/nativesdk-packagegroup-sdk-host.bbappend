
RDEPENDS_${PN} += " \
	nativesdk-cmake \
        nativesdk-protobuf \
        ${@base_contains('DISTRO_FEATURES', 'qt5','nativesdk-qttools-tools \
						   nativesdk-qtbase-tools',' ',d)} \
"
