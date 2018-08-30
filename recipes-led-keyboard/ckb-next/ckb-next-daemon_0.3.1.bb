DESCRIPTION = "Builder/extractor for just the ckb-daemon-next"

require ckb-next-core.inc
PROVIDES = "ckb-next-daemon"

CKB_CMAKE_FLAGS += " \
  -DCMAKE_INSTALL_PREFIX=/usr \
  -DWITH_GUI:BOOL=OFF \
  -DWITH_MVIZ:BOOL=OFF \
  -DICONV_INCLUDE_DIR=${STAGING_INCDIR} \
  -DICONV_LIBRARIES=${STAGING_LIBDIR} \
  -DWITH_ANIMATIONS:BOOL=OFF \
  -DUDEV_LIBRARY=${STAGING_LIBDIR}/libudev.so \
"

EXTRA_OECMAKE += " -DCMAKE_VERBOSE_MAKEFILE:BOOL=ON "

REQUIRED_DISTRO_FEATURES += "systemd"
SYSTEMD_SERVICE_${PN} = "ckb-next-daemon.service"

do_configure () {
  cmake -H${S} -B${B}/build -DCMAKE_BUILD_TYPE=Release ${CKB_CMAKE_FLAGS}
}

do_compile () {
  cmake --build ${B}/build --target daemon
}

do_install () {
  install -d ${D}${bindir}
  install -m 0755 ${B}/build/bin/ckb-next-daemon ${D}${bindir}

  install -d ${D}${systemd_system_unitdir}
  install -m 644 ${B}/build/src/daemon/service/ckb-next-daemon.service ${D}${systemd_system_unitdir}
}

do_clean () {
  rm -rf ${B}/build
}

FILES_${PN} += " \
  ${bindir} \
  ${systemd_system_unitdir} \
  "
