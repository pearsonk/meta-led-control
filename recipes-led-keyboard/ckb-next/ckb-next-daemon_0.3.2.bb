DESCRIPTION = "Builder/extractor for just the ckb-daemon-next"

require ckb-next-core.inc
PROVIDES = "ckb-next-daemon"

CKB_CMAKE_FLAGS += " \
  -DCMAKE_INSTALL_PREFIX=/usr \
  -DWITH_GUI:BOOL=OFF \
  -DWITH_MVIZ:BOOL=OFF \
  -DWITH_ANIMATIONS:BOOL=OFF \
"

# Handle iconv library search
CKB_CMAKE_FLAGS += " \
  -DICONV_INCLUDE_DIR=${STAGING_INCDIR} \
  -DICONV_LIBRARIES=${STAGING_LIBDIR} \
"

# Handle udev library search, since the regular udev and systemd put them in 
# different locations, and the cmake module in ckb-next doesn't handle this.
CKB_CMAKE_FLAGS += " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', ' -DUDEV_LIBRARY=${STAGING_BASELIBDIR}/libudev.so', '-DUDEV_LIBRARY=${STAGING_LIBDIR}/libudev.so', d)}"

EXTRA_OECMAKE += " -DCMAKE_VERBOSE_MAKEFILE:BOOL=ON "

SYSTEMD_SERVICE_${PN} = "ckb-next-daemon.service"

do_configure () {
  cmake -H${S} -B${B} -DCMAKE_BUILD_TYPE=Release ${CKB_CMAKE_FLAGS}
}

do_compile () {
  cmake --build ${B} --target daemon
}

do_install () {
  install -d ${D}${bindir}
  install -m 0755 ${B}/bin/ckb-next-daemon ${D}${bindir}

  install -d ${D}${systemd_system_unitdir}
  install -m 644 ${B}/src/daemon/service/ckb-next-daemon.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += " \
  ${bindir} \
  ${systemd_system_unitdir} \
  "
