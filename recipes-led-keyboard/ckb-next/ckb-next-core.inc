LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRC_URI = "git://github.com/ckb-next/ckb-next.git"

PV = "0.3.0+git${SRCPV}"
SRCREV = "3faa98a72327446fc5175e00c0c305bd727f2219"

S = "${WORKDIR}/git"

inherit cmake qmake5 pkgconfig

DEPENDS += " udev qtbase-native"

TARGET_CC_ARCH += "-pthread"

