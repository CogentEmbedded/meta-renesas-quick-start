FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PATCHTOOL_rcar-gen2 = "git"


SRC_URI_append_stout = '${@ \
	" file://9999a-Use-ramdisk-for-boot.patch " if 'ramdisk' in '${DISTRO_FEATURES}' else ""} \
'


KERNEL_DEVICETREE_porter = '${S}/arch/arm/boot/dts/r8a7791-porter-eavb.dts'

RAMDISK_ENABLE = '${@ "yes" if 'ramdisk' in '${DISTRO_FEATURES}' else "no"}'


do_configure_append() {
    # Enable bootloader args
    kernel_configure_variable ARM_APPENDED_DTB y
    kernel_configure_variable ARM_ATAG_DTB_COMPAT y
    kernel_configure_variable ARM_ATAG_DTB_COMPAT_CMDLINE_FROM_BOOTLOADER y

    # Endable multitoch HID
    kernel_configure_variable HID_MULTITOUCH y

    # Enable EXT4
    kernel_configure_variable EXT4_FS y

    # Enable debugfs
    kernel_configure_variable DEBUG_FS y

    # Enable JPU
    kernel_configure_variable V4L2_MEM2MEM_DEV y
    kernel_configure_variable VIDEO_RENESAS_JPU y

    # Enable touchscreen
    kernel_configure_variable INPUT_TOUCHSCREEN y

    # Enable USB serial to be able to use USB GPS based on PL2303
    kernel_configure_variable USB_SERIAL y
    kernel_configure_variable USB_SERIAL_CONSOLE y
    kernel_configure_variable USB_SERIAL_GENERIC y
    kernel_configure_variable USB_SERIAL_PL2303 y

    # Enable Logitech Wheel drivers for G27
    kernel_configure_variable INPUT_JOYDEV y
    kernel_configure_variable HID_LOGITECH y
    kernel_configure_variable LOGIWHEELS_FF y

    # Enable camera
    kernel_configure_variable SOC_CAMERA_OV10635 y
    kernel_configure_variable SOC_CAMERA_MAX9272_OV10635 y

    # Enable ravb
    kernel_configure_variable RAVB y

    # Enable Networking over USB
    kernel_configure_variable USB_USBNET y
    kernel_configure_variable USB_NET_AX8817X y
    kernel_configure_variable USB_NET_AX88179_178A y

    yes '' | oe_runmake oldconfig
}


do_configure_append() {

if [ "${RAMDISK_ENABLE}" = "yes" ]; then
    # Enable ramdisk support for initramfs
    kernel_configure_variable MTD y
    kernel_configure_variable MTD_NAND y
    kernel_configure_variable MTD_NAND_VERIFY_WRITE y
    kernel_configure_variable MTD_BLOCK y
    kernel_configure_variable MTD_CHAR y
    kernel_configure_variable MTD_RAM y
    kernel_configure_variable MTD_PARTITIONS y
    kernel_configure_variable MTD_BLKDEVS y
    kernel_configure_variable MTD_CMDLINE_PARTS y
    kernel_configure_variable BLK_DEV_RAM y
    kernel_configure_variable BLK_DEV_RAM_COUNT 1
    kernel_configure_variable BLK_DEV_RAM_SIZE 786432
    kernel_configure_variable BLK_DEV_INITRD y
    kernel_configure_variable RD_GZIP y
    kernel_configure_variable RD_LZMA y
    kernel_configure_variable RD_XZ y
    kernel_configure_variable MTD_UBI y
    kernel_configure_variable FTL y
    kernel_configure_variable NFTL y
    kernel_configure_variable NFTL_RW y
    kernel_configure_variable INFTL y
    kernel_configure_variable JFFS2 y
    kernel_configure_variable JFFS2_LZO y

    # Enable JPU
    kernel_configure_variable V4L2_MEM2MEM_DEV y
    kernel_configure_variable VIDEO_RENESAS_JPU y
    kernel_configure_variable VIDEO_ADV_DEBUG y
    
    # Enable camera
    kernel_configure_variable SOC_CAMERA_OV10635 n
    kernel_configure_variable SOC_CAMERA_MAX9272_OV10635 y

    # Enable ravb
    kernel_configure_variable RAVB y

    # Enable Networking over USB
    kernel_configure_variable USB_USBNET y
    kernel_configure_variable USB_NET_AX8817X y
    kernel_configure_variable USB_NET_AX88179_178A y

    kernel_configure_variable PRINTK_TIME y

    # Disable unnecessary stuff
    kernel_configure_variable BT n

    # Disable sound

    kernel_configure_variable SND_SUPPORT_OLD_API n
    kernel_configure_variable SND_VERBOSE_PROCFS n

    kernel_configure_variable SND_SPI n
    kernel_configure_variable SND_USB n

    kernel_configure_variable SND_DRIVERS n
    kernel_configure_variable SND_PCI n

    kernel_configure_variable SND_ARM n
    kernel_configure_variable SND_SOC_RCAR n
    kernel_configure_variable SND_SOC_AK4642 n
    kernel_configure_variable SND_SIMPLE_CARD n

    # Disable some cameras
    kernel_configure_variable SOC_CAMERA_MT9T112 n

    # No SATA and IDE
    kernel_configure_variable SATA_RCAR n
    kernel_configure_variable HAVE_IDE n

    # No wifi
    kernel_configure_variable WIRELESS n
    kernel_configure_variable WLAN n

fi

    yes '' | oe_runmake oldconfig
}

MACHINE_FEATURES_append_stout = " stout-view"

do_install_append() {
    if [ -f ${B}/arch/${ARCH}/boot/uImage+dtb ]; then
        install -m 644 ${B}/arch/${ARCH}/boot/uImage+dtb ${D}/boot/
    fi
}


