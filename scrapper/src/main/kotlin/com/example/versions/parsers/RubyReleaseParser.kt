package com.example.versions.parsers

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class RubyReleaseParser : ReleaseParser {
    companion object {
        const val BASE_URL = "www.ruby-lang.org"
        const val RELEASE_VERSION = "Ruby\\s(\\d{1,2}\\.\\d{1,2}\\.\\d{1,2})"
    }

    override fun parse(document: Document?): Release =
        document?.let {
            val element = document.select("tr:matches($RELEASE_VERSION)")
                    .first { el -> !el.text().contains("-preview") }
            val name = element.getElementsByTag("td").first()
            val a = element.getElementsByTag("a").first()
            Release(name.getVersion(), listOf(a.getHref()))
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