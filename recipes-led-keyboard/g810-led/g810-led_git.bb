DESCRIPTION = "g810-led recipe for driving applications g810-led"

include g810-led-core.inc

S = "${WORKDIR}/git"

DEPENDS += "hidapi libg810-led"

do_compile () {
	oe_runmake bin-linked
}

do_install () {
	install -m 755 -d ${D}${bindir}
  install -m 755 ${S}/bin/g810-led ${D}${bindir}
}

