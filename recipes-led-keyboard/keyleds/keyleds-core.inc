LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d4333f07cbfa8fe036e90820f556b2ad"

SRC_URI = "git://github.com/pearsonk/keyleds.git;branch=relocate-qt-check \
"

PV = "0.7.7+git${SRCPV}"
#SRCREV = "6554ee289a73a52f7461302f99cb1b9ca883f9e3"
SRCREV = "${AUTOREV}"

inherit pkgconfig cmake

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

DEPENDS += " "
