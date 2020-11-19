package org.margo.languagesradar

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.margo.languagesradar.parsers.Release
import org.margo.languagesradar.parsers.ReleaseParser
import java.lang.Exception

object Scrapper {
    private val documents: MutableMap<Language, Document?> = mutableMapOf();
    private val parsers: Map<Language, ReleaseParser> = mapOf()
    
    private fun connect() {
        documents.plus(
            Languages.releasesUrl.map { (lang, url) -> lang to url.connect()}
        )
    }
    
    private fun getLatestVersions() : Map<Language, Release?> {
        return documents.map { (lang, doc) -> lang to parsers[lang]?.parse(doc) }.toMap()
    }
    
    private fun String.connect() : Document? {
        return try {
            Jsoup.connect(this).get()
        } catch (e: Exception) {
            //handle exceptions here
            return null
        }
    }
    
}



