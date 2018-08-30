LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRC_URI = "git://github.com/pearsonk/ckb-next.git;branch=kmp-fixes \
"

PV = "0.3.1+git${SRCPV}"
#SRCREV = "6554ee289a73a52f7461302f99cb1b9ca883f9e3"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

DEPENDS += " udev virtual/libiconv"

TARGET_CC_ARCH += "-pthread"

