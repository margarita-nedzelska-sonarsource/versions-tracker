package com.example.versions.html

import com.example.versions.data.ReleaseRecord
import kotlinx.html.*

fun HTML.toHtml(result: List<ReleaseRecord>) {
    head {
        title {
            +"Versions"
        }
        addCustomStyle()
    }
    body {
        h2 {
            +"Versions"
        }
        table {
            releaseHeader()
            result.forEach { releaseRow(it) }
        }

    }
}

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