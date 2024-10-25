LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

PV = "v0.6.0"
SRC_URI = "git://github.com/ckb-next/ckb-next.git;protocol=https;branch=master;tag=${PV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit pkgconfig cmake systemd

DEPENDS += "udev virtual/libiconv"

TARGET_CC_ARCH += "-pthread"

