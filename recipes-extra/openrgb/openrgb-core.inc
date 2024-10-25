LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f410bb3d75cabf5bb7e6df0381bbb6b6"

PV = "0.9"
SRC_URI = "git://gitlab.com/CalcProgrammer1/OpenRGB;protocol=https;branch=master;tag=release_${PV} \
"

inherit qmake5

DEPENDS += "hidapi"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
