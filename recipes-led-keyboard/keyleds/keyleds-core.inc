LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d4333f07cbfa8fe036e90820f556b2ad"

SRC_URI = "git://github.com/keyleds/keyleds.git \
"

PV = "1.1.0+git${SRCPV}"
SRCREV = "af5c22ba709af047659159c01caea79cc2fdc9d7"

inherit pkgconfig cmake

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

DEPENDS += " "
