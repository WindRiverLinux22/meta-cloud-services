do_install:append() {
    # Remove /var/run as it is created on startup
    rm -rf ${D}${localstatedir}/run
}
