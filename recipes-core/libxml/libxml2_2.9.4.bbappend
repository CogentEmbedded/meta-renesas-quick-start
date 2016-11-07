
do_install_append_class-nativesdk() {
	# remove empty directories
	cd ${D}
	find . -type d -depth -empty -exec rmdir "{}" \;
}


FILES_${PN}-staticdev_class-nativesdk += "\
	${PYTHON_SITEPACKAGES_DIR}/*.a \
	${libdir}/*.a \
"

FILES_${PN}_class-nativesdk += "\
	${PYTHON_SITEPACKAGES_DIR} \
	${libdir} \
"

FILES_${PN}-dbg_class-nativesdk += "\
	${PYTHON_SITEPACKAGES_DIR}/.debug \
	${bindir}/.debug \
	${libdir}/.debug \
"
