SECTION = "kernel"
DESCRIPTION = "Linux kernel for Pandaboard ES rev.B3"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc
#require recipes-kernel/linux/cmem.inc
require recipes-kernel/linux/ti-uio.inc

# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.9:"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_pandaboard = "omap4-panda.dtb omap4-panda-a4.dtb omap4-panda-es.dtb"
KERNEL_DEVICETREE_panda-es-rev-b3 = "omap4-panda-es-b3.dtb"

COMPATIBLE_MACHINE = "panda-es-rev-b3"

S = "${WORKDIR}/git"

SRCREV = "69f1789e717d80fa7701e067eaa7389a7ea2f4e5"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

BRANCH = "ti-lsk-linux-4.9.y"
KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig"
SRC_URI += "file://0005-arm-dts-omap4-move-emif-so-panda-es-b3-now-boots.patch"
