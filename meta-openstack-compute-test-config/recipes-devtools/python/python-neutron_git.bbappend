FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://neutron-test-config.init"

NEUTRON_CONF_EXT_ETH_IF ?= "eth0"

do_install:append() {
    sed -e "s:%NEUTRON_CONF_EXT_ETH_IF%:${NEUTRON_CONF_EXT_ETH_IF}:g" -i ${WORKDIR}/neutron-test-config.init
    sed -e "s:%COMPUTE_IP%:${COMPUTE_IP}:g" -i ${WORKDIR}/neutron-test-config.init
    install -m 0755 ${WORKDIR}/neutron-test-config.init ${D}${sysconfdir}/init.d/neutron-test-config
}

PACKAGES += " ${SRCNAME}-test-config"
FILES:${SRCNAME}-test-config = "${sysconfdir}/init.d/neutron-test-config"

RDEPENDS:${SRCNAME}-tests += "${SRCNAME}-test-config"

INITSCRIPT_PACKAGES += " ${SRCNAME}-test-config"
INITSCRIPT_NAME:${SRCNAME}-test-config = "neutron-test-config"
INITSCRIPT_PARAMS:${SRCNAME}-test-config = "defaults 95 10"
