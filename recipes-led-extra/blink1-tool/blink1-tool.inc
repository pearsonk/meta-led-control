LICENSE = "CC-BY-SA-3.0 & GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4d831d7789a243ed364321642e0dbb54 \
                    file://hidapi/LICENSE-gpl3.txt;md5=d32239bcb673463ab874e80d47fae504 \
                    file://hidapi/LICENSE-bsd.txt;md5=b5fa085ce0926bb50d0621620a82361f \
                    file://hidapi/LICENSE-orig.txt;md5=e0ea014f523f64f0adb13409055ee59e \
                    file://hidapi/LICENSE.txt;md5=7c3949a631240cb6c31c50f3eb696077"

SRC_URI = "https://github.com/todbot/blink1-tool.git"

SRCREV = "7c822b4fc2ac6f761309c9f22c57eee05a5de0ea"

PV = "1.0+git${SRCPV}"

#Skip QA warning, since upstream doesn't build/symlink the library
INSANE_SKIP_${PN}-dev += "dev-elf "

