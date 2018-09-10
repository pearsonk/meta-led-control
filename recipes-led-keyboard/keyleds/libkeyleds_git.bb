DESCRIPTION = "Library for the keyleds project"

require keyleds-core.inc
PROVIDES = "libkeyleds"

CMAKE_FLAGS += " \
  -DWITH_KEYLEDSD:BOOL=OFF \
"

do_configure () {
  cd ${B}
  cmake -DCMAKE_BUILD_TYPE=Release ${CMAKE_FLAGS} ${S}
}

do_compile () {
  oe_runmake -C ${B} libkeyleds
}

do_install () {
  install -d ${D}${libdir}
  oe_soinstall ${B}/lib/libkeyleds.so.1.0 ${D}${libdir}
}

do_clean () {
  oe_runmake -C ${B} clean
}
