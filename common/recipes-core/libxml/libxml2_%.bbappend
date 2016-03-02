
do_install_append_class-nativesdk() {
    	# fixup invalid install
	mv -f ${D}${STAGING_DIR}/${TARGET_SYS}/usr/lib/python* ${D}${libdir}

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
