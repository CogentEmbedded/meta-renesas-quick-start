FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PATCHTOOL_rcar-gen2 = "git"


KERNEL_DEVICETREE_porter = '${S}/arch/arm/boot/dts/r8a7791-porter-eavb.dts'


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


MACHINE_FEATURES_append_stout = " stout-view"

do_install_append() {
    if [ -f ${B}/arch/${ARCH}/boot/uImage+dtb ]; then
        install -m 644 ${B}/arch/${ARCH}/boot/uImage+dtb ${D}/boot/
    fi
}


