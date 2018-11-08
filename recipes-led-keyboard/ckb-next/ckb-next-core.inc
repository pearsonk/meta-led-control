LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRC_URI = "git://github.com/ckb-next/ckb-next.git \
"

PV = "0.3.2+git${SRCPV}"
SRCREV = "78b6557dac4a2828c2dda46185fae44ee9e075ea"
#SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

DEPENDS += " udev virtual/libiconv"

TARGET_CC_ARCH += "-pthread"

