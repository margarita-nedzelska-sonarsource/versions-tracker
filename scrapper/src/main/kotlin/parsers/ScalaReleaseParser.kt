package org.margo.languagesradar.parsers

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class ScalaReleaseParser : ReleaseParser {
    companion object {
        const val BASE_URL = "github.com"
        val RELEASE_VERSION = Regex("Scala\\s(\\d{1,2}\\.\\d{1,2}\\.\\d{1,2})")
    }

    override fun parse(document: Document?): Release =
        document?.let {
            val element = it.body().getElementsByClass("release-header").first()
            val a = element.getElementsByTag("a").first()
            Release(a.getVersion(), listOf(a.getHref()))
        } ?: Release.EMPTY_RELEASE
    
    
    private fun Element?.getVersion(): String =
            this?.let {
                RELEASE_VERSION.find(it.text())
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