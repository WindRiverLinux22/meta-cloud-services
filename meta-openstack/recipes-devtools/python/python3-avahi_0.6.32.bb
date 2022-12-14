RDEPENDS:${PN} += "python3-core python3-dbus"
SUMMARY = "Python bindings for the avahi zeroconf client"
HOMEPAGE = "https://github.com/lathiat/avahi"
SECTION = "devel/python"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "https://github.com/lathiat/avahi/releases/download/v${PV}/avahi-${PV}.tar.gz"

SRC_URI[md5sum] = "22b5e705d3eabb31d26f2e1e7b074013"
SRC_URI[sha256sum] = "d54991185d514a0aba54ebeb408d7575b60f5818a772e28fa0e18b98bc1db454"

S = "${WORKDIR}/avahi-${PV}"

inherit python3native python3-dir

# we only need the python bindings
do_install () {
	install -d ${D}${PYTHON_SITEPACKAGES_DIR}/avahi

	sed -i'' -e "s,@PYTHON\@,${bindir}/${PYTHON_PN},g" \
		${S}/avahi-python/avahi/__init__.py  \
		${S}/avahi-python/avahi-bookmarks.in

	install -m 0775 ${S}/avahi-python/avahi/__init__.py \
		${D}${PYTHON_SITEPACKAGES_DIR}/avahi/__init__.py

	install -m 0775 ${S}/avahi-python/avahi-bookmarks.in \
		${D}${PYTHON_SITEPACKAGES_DIR}/avahi/avahi-bookmarks
}

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/avahi"
