package org.margo.languagesradar.server.html

import kotlinx.html.*
import org.margo.languagesradar.server.data.ReleaseRecord

fun HEAD.addCustomStyle() {
    style {
        unsafe {
            raw(
                """table td {
                                    border: 1px solid black;
                                    text-align: center;
                                    }"""
            )
        }
    }
}

fun TABLE.releaseHeader() {
    tr {
        td {
            text("Language")
        }
        td {
            text("Supported Version")
        }
        td {
            text("Latest Version")
        }
        td {
            text("Release Note")
        }
    }
}

fun TABLE.releaseRow(record: ReleaseRecord) {
    tr {
        td {
            text("${record.language}")
        }
        td {
            text(record.supportedVersion)
        }
        td {
            text(record.latestVersion)
        }
        td {
            text(record.latestReleaseNote)
        }
    }
}