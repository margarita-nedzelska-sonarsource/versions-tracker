package com.example.versions.parsers

import com.example.versions.Project
import com.example.versions.Languages
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class ScalaReleaseParser : ReleaseParser {
    companion object {
        const val BASE_URL = "github.com"
        val RELEASE_VERSION = Regex("Scala\\s(\\d{1,2}\\.\\d{1,2}\\.\\d{1,2})")
    }

    override fun parse(document: Document?): Release =
        document?.let {
            val element = it.body()
                    .getElementsByClass("release-header")
                    .flatMap { el -> el.getElementsByTag("a")  }
                    .filter { el -> el.getVersion() >= Languages.LATEST_KNOWN_VERSIONS[Project.SCALA]!! }
                    .first()
            Release(element.getVersion(), listOf(element.getHref()))
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
