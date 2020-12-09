package com.example.versions.parsers

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class KotlinReleaseParser : ReleaseParser {
    companion object {
        const val RELEASES_URL = "kotlinlang.org/releases.html"
        val RELEASE_VERSION = Regex("\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}")
    }

    override fun parse(document: Document?): Release =
        document?.let {
            val element = it.body().getElementsByTag("td").first()
            Release(element.getVersion(), listOf(RELEASES_URL))
        } ?: Release.EMPTY_RELEASE
    
    
    private fun Element?.getVersion(): String =
            this?.let {
                RELEASE_VERSION.find(it.text())
                        ?.groups?.get(0)?.value
                        ?: "0"
            } ?: ""
}