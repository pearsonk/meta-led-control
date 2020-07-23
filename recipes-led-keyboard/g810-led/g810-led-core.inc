LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/MatMoul/g810-led.git"

PV = "0.4.2+git${SRCPV}"
SRCREV = "5ee810a520f809e65048de8a8ce24bac0ce34490"

DEPENDS += "hidapi"
