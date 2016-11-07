FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Workaround strange CMake 2.8.1 bug.  I do not understand it since ${AR} is set
EXTRA_OECMAKE_class-native += "-DCMAKE_AR=/usr/bin/${AR}"
#EXTRA_OECMAKE_class-nativesdk += "-DCMAKE_AR=/usr/bin/${AR}"

# Old bitbake cannot handle ";" after file specification
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=4c0bc17c954e99fd547528d938832bfa \
                    file://tools/clang/LICENSE.TXT;md5=82ed8fe1976ca709bbd81f4f10a48ccd \
                    "

SRC_URI_append = " \
	file://0001-Export-all-symbols-into-the-shared-library.patch \
	file://0002-Fix-shared-lib-generation.patch \
"

DEPENDS_class-target += "clang-native"

FILES_${PN} += " \
    ${datadir}/llvm \
    ${libdir}/BugpointPasses.so \
    ${libdir}/LLVMHello.so \
"

EXTRA_OECMAKE_append_class-target = "\
               -DLLVM_ENABLE_PIC=True \
               -DBUILD_SHARED_LIBS=False \
               -DLLVM_BUILD_LLVM_DYLIB=True \
               -DLLVM_DYLIB_EXPORT_ALL=True \
	       -DLLVM_DYLIB_COMPONENTS:string="all" \
"

do_configure_append_class-target() {
	# create a wrapper around native llvm-config
	cat <<EOF > ${S}/llvm-config
#!/bin/sh
BASEDIR=\$(dirname \$0)
${STAGING_BINDIR_NATIVE}/llvm-config \$@ | sed -f \${BASEDIR}/llvm-config.sed
EOF

	# make all replacements
	cat <<EOF > ${S}/llvm-config.sed
#!/usr/bin/sed -f
s|${STAGING_DIR_NATIVE}${base_libdir_native}/llvm|${STAGING_DIR_TARGET}${libdir}|g
s|${STAGING_DIR_NATIVE}${libdir_native}|${STAGING_DIR_TARGET}${libdir}|g
s|${STAGING_DIR_NATIVE}${base_libdir_native}|${STAGING_DIR_TARGET}${libdir}|g
s|${STAGING_DIR_NATIVE}${includedir_native}|${STAGING_DIR_TARGET}${includedir}|g
s|${STAGING_DIR_NATIVE}|${STAGING_DIR_TARGET}|g
s|AArch64.ARM.Mips.PowerPC.X86|${@get_clang_target_arch(bb, d)}|g
s|x86_64-unknown-linux-gnu|${TARGET_ARCH}-unknown-linux-gnu|g
EOF

}

do_install_append_class-target(){
	# install a wrapper around native llvm-config
	install -d ${D}${bindir_crossscripts}
	install -m 755 ${S}/llvm-config ${D}${bindir_crossscripts}
	install -m 755 ${S}/llvm-config.sed ${D}${bindir_crossscripts}
}

SYSROOT_PREPROCESS_FUNCS_class-target += "clang_sysroot_preprocess"

clang_sysroot_preprocess () {
	sysroot_stage_dir ${D}${bindir_crossscripts} ${SYSROOT_DESTDIR}${bindir_crossscripts}
}

