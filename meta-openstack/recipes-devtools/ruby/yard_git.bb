#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "A documentation generation tool for the Ruby programming language."
DESCRIPTION = "YARD is a documentation generation tool for the Ruby \
programming language. It enables the user to generate consistent, \
usable documentation that can be exported to a number of formats very \
easily, and also supports extending for custom Ruby constructs such as \
custom class level definitions."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b3e127de4b3f2e58562183d9aba9a7f6"

PR = "r0"

BPV = "0.8.7.6"
PV = "${BPV}"
SRCREV = "d83194e1a09098ec5be28b616cde3b9a15380873"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/lsegal/yard.git;branch=main;protocol=https \
    "

inherit ruby

BBCLASSEXTEND = "native"
