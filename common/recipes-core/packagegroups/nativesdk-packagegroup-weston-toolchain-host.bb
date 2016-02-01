SUMMARY = "Host packages for Weston standalone SDK or external toolchain"
LICENSE = "MIT"

inherit nativesdk packagegroup

RDEPENDS_${PN} += " \
    nativesdk-packagegroup-sdk-host \
"
