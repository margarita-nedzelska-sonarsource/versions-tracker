package org.margo.languagesradar

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.margo.languagesradar.Language.*
import org.margo.languagesradar.parsers.*
import java.lang.Exception

fun main() {
    val latestVersions = Scrapper.getLatestVersions(SCALA, JAVA, KOTLIN, GO, RUBY)
    latestVersions.forEach(::println)
}

object Scrapper {
    private val parsers: Map<Language, ReleaseParser> = mapOf(
            JAVA to JavaReleaseParser(),
            KOTLIN to KotlinReleaseParser(),
            SCALA to ScalaReleaseParser(),
            GO to GoReleaseParser(),
            RUBY to RubyReleaseParser(),
    )
    
    fun getLatestVersions(vararg langs: Language) : Map<Language, Release?> =
        langs.map {
            val url = Languages.releasesUrl[it]
            it to parsers[it]?.parse(url?.connect())
        }.toMap()
    
    
    private fun String.connect() : Document? {
        return try {
            Jsoup.connect(this).get()
        } catch (e: Exception) {
            //handle exceptions here
            println("Sth bad happened : ${e.message}")
            null
        }
    }
    
}



