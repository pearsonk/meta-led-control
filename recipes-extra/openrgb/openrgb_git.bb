DESCRIPTION = "Recipe for building OpenRGB"

require openrgb-core.inc
PROVIDES = "openrgb"

do_configure () {
    ${OE_QMAKE_QMAKE} ${S}/OpenRGB.pro
}

do_compile () {
  oe_runmake
}


DEPENDS += "qtbase mbedtls qttools-native"

FILES_${PN} += " \
  ${bindir} \
  ${datadir}/metainfo \
  ${datadir}/icons \
  "
