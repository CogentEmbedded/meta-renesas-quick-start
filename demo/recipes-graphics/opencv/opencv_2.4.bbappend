SRC_URI = "git://github.com/Itseez/opencv.git;branch=2.4 \
"

inherit cmake_qt5

SRCREV = "707d10f11526afee1e1a35ec7fdaa8b05f7e1656"
PV = "2.4.11+git${SRCPV}"

# We have to disable jasper completely as it cause "internal compiler error"
PACKAGECONFIG[jasper] = "-DWITH_JASPER=ON,-DWITH_JASPER=OFF,"
PACKAGECONFIG[qt5] = "-DWITH_QT=ON,-DWITH_QT=OFF,qtbase,"
PACKAGECONFIG[v4l] = "-DWITH_V4L=ON,-DWITH_V4L=OFF,,"
PACKAGECONFIG[neon] = "-DENABLE_NEON=ON,-DENABLE_NEON=OFF,,"
PACKAGECONFIG[gstreamer] = "-DWITH_GSTREAMER=ON,-DWITH_GSTREAMER=OFF,gstreamer1.0,"
PACKAGECONFIG[opengl] = "-DWITH_OPENGL=ON,-DWITH_OPENGL=OFF,,"
PACKAGECONFIG[opencl] = "-DWITH_OPENCL=ON,-DWITH_OPENCL=OFF,,"

PACKAGECONFIG_QT5 = "qt5"
PACKAGECONFIG = " \
	neon \
	gstreamer \
	jpeg \
	png \
	tiff \
	${PACKAGECONFIG_QT5} \
"

