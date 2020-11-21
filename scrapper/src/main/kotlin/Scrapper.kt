package org.margo.languagesradar

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.margo.languagesradar.parsers.JavaReleaseParser
import org.margo.languagesradar.parsers.KotlinReleaseParser
import org.margo.languagesradar.parsers.Release
import org.margo.languagesradar.parsers.ReleaseParser
import java.lang.Exception

fun main() {
    val latestVersions = Scrapper.getLatestVersions(Language.KOTLIN)
    println(latestVersions)
}

object Scrapper {
    private val parsers: Map<Language, ReleaseParser> = mapOf(
            Language.JAVA to JavaReleaseParser(),
            Language.KOTLIN to KotlinReleaseParser()
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
            return null
        }
    }
    
}



