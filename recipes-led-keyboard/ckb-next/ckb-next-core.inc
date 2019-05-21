LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRC_URI = "git://github.com/ckb-next/ckb-next.git"

PV = "0.4.0+git${SRCPV}"
SRCREV = "d6a5c4f3c630df2333800ce0d293fe01d6b7461a"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit pkgconfig cmake systemd

DEPENDS += "udev virtual/libiconv"

TARGET_CC_ARCH += "-pthread"

