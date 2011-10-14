DESCRIPTION = "Miredo is an open-source Teredo IPv6 tunneling software"
SRC_URI = "\
http://www.remlab.net/files/miredo/miredo-${PV}.tar.bz2 \
file://0001-Decreasing-security-using-dev-urandom.patch \
file://client-hook \
file://miredo.conf \
file://miredo-start.sh \
"
LICENSE = "GPL"
PR = "r2"
inherit autotools gettext
EXTRA_OECONF = "ac_cv_file__proc_self_maps=yes"
SRC_URI[md5sum] = "1281e7e75bddbde244cd778d99fa22d4"
SRC_URI[sha256sum] = "8fab1fbdae1a8cd5448066f961f5c069eab4250f4308273a66c023afcc8d839e"

do_install_append() {
	install -d ${D}${sysconfdir}/miredo
	install -d ${D}${sysconfdir}/ppp/ip-up.d
	install -m 755 ${WORKDIR}/client-hook \
		${D}${sysconfdir}/miredo/client-hook
	install -m 755 ${WORKDIR}/miredo.conf \
		${D}${sysconfdir}/miredo/miredo.conf
	install -m 755 ${WORKDIR}/miredo-start.sh \
		${D}${sysconfdir}/ppp/ip-up.d/miredo-start.sh
}

