package org.margo.languagesradar.parsers

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class SwiftReleaseParser : ReleaseParser {
    companion object {
        const val BASE_URL = "https://swift.org/"
        const val RELEASE_VERSION = "swift-(\\d\\.\\d(\\.\\d)?)-RELEASE"
    }

    override fun parse(document: Document?): Release =
        document?.let {
            val a = document.select("h2#releases + h3 + p a").first()
            Release(a.getVersion(), listOf(a.getHref()))
        } ?: Release.EMPTY_RELEASE
    
    
    private fun Element?.getVersion(): String =
            this?.let {
                Regex(RELEASE_VERSION).find(it.text())
                        ?.groups?.get(1)?.value
                        ?: "0"
            } ?: ""

    private fun Element?.getHref(): String =
            this?.attr("href") ?: BASE_URL

}