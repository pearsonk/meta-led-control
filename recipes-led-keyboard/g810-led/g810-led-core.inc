LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/MatMoul/g810-led.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "0217f786cb2833a9f46b56f6fcab8f25ee36c01bd99142587b5e387173ca1850"

PV = "0.4.2"
SRCREV = "5ee810a520f809e65048de8a8ce24bac0ce34490"

DEPENDS += "hidapi"
