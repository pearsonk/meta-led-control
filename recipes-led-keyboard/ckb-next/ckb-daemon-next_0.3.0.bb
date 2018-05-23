DESCRIPTION = "Builder/extractor for just the ckb-daemon-next"

require ckb-next-core.inc

CKB_CMAKE_FLAGS += " \
  -DCMAKE_INSTALL_PREFIX=/usr \
  -DWITH_GUI:BOOL=OFF \
  -DWITH_MVIZ:BOOL=OFF \
  -DWITH_ANIMATIONS:BOOL=OFF \
  -DICONV_LIBRARIES=${OE_QMAKE_PATH_HOST_LIBS} \
  -DUDEV_LIBRARY=${OE_QMAKE_PATH_HOST_LIBS}/libudev.so \ 
  -DUDEV_INCLUDE_DIR=${OE_QMAKE_PATH_HEADERS} \ 
  -DQuaZip_LIBRARIES=${OE_QMAKE_PATH_HOST_LIBS} \
  -DQuaZip_INCLUDE_DIRS=${OE_QMAKE_PATH_HEADERS} \
"
BDIR_DAEMON = "${WORKDIR}/build/daemon"

REQUIRED_DISTRO_FEATURES += "systemd"
SYSTEMD_SERVICE_${PN} = "ckb-next-daemon.service"


do_configure () {
  cmake -H${S} -Bdaemon -DCMAKE_BUILD_TYPE=Release ${CKB_CMAKE_FLAGS}
}

do_compile () {
  cmake --build ${BDIR_DAEMON} --target daemon
}

do_install () {
  install -d ${D}${bindir}
  install -m 0755 ${BDIR_DAEMON}/bin/ckb-next-daemon ${D}${bindir}

  install -d ${D}${systemd_system_unitdir}
  install -m 644 ${BDIR_DAEMON}/src/daemon/service/ckb-next-daemon.service ${D}${systemd_system_unitdir}
}

do_clean () {
  rm -rf ${BDIR}
}

FILES_${PN} += " \
  ${bindir} \
  ${systemd_system_unitdir} \
  "
