require blink1-tool.inc

inherit pkgconfig
PROVIDES = "blink1-lib"

DEPENDS += "hidapi"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"

S = "${WORKDIR}/git"

do_compile () {
	oe_runmake lib
}

do_install () {
	oe_runmake install-dev PREFIX=${D}${exec_prefix}
}

SOLIBS += "*.so"

FILES_${PN} += " \
  ${libdir}/libblink1.so \
  "

FILES_${PN}-dev += " \
  ${includedir}/blink1-lib.h \
  "
