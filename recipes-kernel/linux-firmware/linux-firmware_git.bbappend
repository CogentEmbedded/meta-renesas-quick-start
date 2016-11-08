LICENSE_${PN}-rtl8188eu = "Firmware-rtlwifi_firmware"

FILES_${PN}-rtl8188eu = " \
    /lib/firmware/rtlwifi/rtl8188eufw*.bin \
"

RDEPENDS_${PN}-rtl8188eu += "${PN}-rtl-license"

PACKAGES =+ " ${PN}-rtl8188eu"

FILES_${PN}-ath9k += " \
    /lib/firmware/ath9k_htc/htc*.fw \
"


