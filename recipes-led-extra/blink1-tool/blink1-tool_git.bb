require blink1-tool.inc

inherit pkgconfig
PROVIDES = "blink1-tool"

DEPENDS += "hidapi blink1-lib"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"

S = "${WORKDIR}/git"

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install PREFIX=${D}${exec_prefix}
}

FILES_${PN} += " \
  ${bindir}/blink1-tool \
  "

