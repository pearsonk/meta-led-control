LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRC_URI = "git://github.com/ckb-next/ckb-next.git"

PV = "0.4.2+git${SRCPV}"
SRCREV = "1555ca97a7e34e8b1e5b5c4d78b4db472bab7f03"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit pkgconfig cmake systemd

DEPENDS += "udev virtual/libiconv"

TARGET_CC_ARCH += "-pthread"

