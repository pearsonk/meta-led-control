require blink1-tool.inc

inherit pkgconfig
PROVIDES = "blink1-tool"

DEPENDS += "hidapi libblink1"

S = "${WORKDIR}/git"

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install PREFIX=${exec_prefix}
}

FILES_${PN} += " \
  ${bindir}/blink1-tool \
  "

