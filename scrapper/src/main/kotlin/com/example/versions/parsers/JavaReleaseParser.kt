package com.example.versions.parsers

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class JavaReleaseParser : ReleaseParser {
    companion object {
        const val BASE_URL = "oracle.com"
        val RELEASE_REGEX = Regex("JDK (\\d+) Release notes")
    }

    override fun parse(document: Document?): Release =
            document?.let {
                val element = it.body().getElementsByTag("a")
                        .find { a -> a.text().matches(RELEASE_REGEX) }

                val version = element.getVersion()
                val href = element.getHref()
                Release(version, listOf(href))
            } ?: Release.EMPTY_RELEASE

    private fun Element?.getVersion(): String =
            this?.let {
                RELEASE_REGEX.find(it.text())
                        ?.groups?.get(1)?.value
                        ?: "0"
            } ?: ""

    private fun Element?.getHref(): String =
            this?.let {
                it.attr("href")
                        ?.let { ref -> "$BASE_URL$ref" }
                        ?: BASE_URL
            } ?: BASE_URL
}