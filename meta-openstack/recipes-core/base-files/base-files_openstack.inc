FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://nsswitch.conf"

PACKAGECONFIG ?= "${@bb.utils.contains('DISTRO_FEATURES', 'OpenLDAP', 'OpenLDAP', '', d)}"
PACKAGECONFIG[OpenLDAP] = ",,,nss-pam-ldapd"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'OpenLDAP', 'true', 'false', d)}; then
        install -m 755 -d ${D}/etc/
        install -m 644 ${WORKDIR}/nsswitch.conf ${D}/etc/
    fi
}
