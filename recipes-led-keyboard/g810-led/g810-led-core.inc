LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/MatMoul/g810-led.git"

PV = "0.3.3+git${SRCPV}"
SRCREV = "b402e367ad50a1d8d7054de6a73181d777aae4d1"

DEPENDS += "hidapi"
