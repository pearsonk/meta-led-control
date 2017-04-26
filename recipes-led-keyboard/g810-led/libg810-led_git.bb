DESCRIPTION = "Library builder for libg810-led"

include g810-led-core.inc

S = "${WORKDIR}/git"

DEPENDS += "hidapi"

INSANE_SKIP_${PN} = "dev-so"

do_compile () {
	oe_runmake lib
}

do_install () {
  oe_runmake libdir=${D}${libdir} includedir=${D}${includedir} install-dev
}

SOLIBS = "*.so*"
FILES_SOLIBSDEV = ""

FILES_${PN}-dev += " \
  ${includedir}/g810-led/*.h \
  "
