package org.margo.languagesradar.parsers

import org.jsoup.nodes.Document

interface ReleaseParser {
    fun parse(document: Document?): Release
}

data class Release(val version: String, val notes: List<String>)