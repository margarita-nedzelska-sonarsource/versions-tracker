package org.margo.languagesradar.parsers

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class GoReleaseParser : ReleaseParser {
    companion object {
        const val BASE_URL = "golang.org"
        const val RELEASE_VERSION = "Go\\s(\\d+\\.\\d{2})\\sRelease\\sNotes"
    }

    override fun parse(document: Document?): Release =
        document?.let {
            val a = document.selectFirst("a:matchesOwn($RELEASE_VERSION)")
            Release(a.getVersion(), listOf(a.getHref()))
        } ?: Release.EMPTY_RELEASE
    
    
    private fun Element?.getVersion(): String =
            this?.let {
                Regex(RELEASE_VERSION).find(it.text())
                        ?.groups?.get(1)?.value
                        ?: "0"
            } ?: ""

    private fun Element?.getHref(): String =
            this?.let {
                it.attr("href")
                        ?.let { ref -> "${BASE_URL}$ref" }
                        ?: BASE_URL
            } ?: BASE_URL

}