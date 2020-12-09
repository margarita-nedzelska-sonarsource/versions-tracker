package com.example.versions

import com.example.versions.Language.*
import com.example.versions.data.ReleaseRecord
import com.example.versions.parsers.*
import com.example.versions.parsers.github.DottyGithubParser
import com.example.versions.parsers.github.GithubParser
import com.example.versions.parsers.github.SwiftGithubParser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.util.*

suspend fun main() {
    val latestVersions = Scrapper.getLatestVersions(SCALA, JAVA, KOTLIN, GO, RUBY, SWIFT, DOTTY)
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

    private val gitHubParsers: Map<Language, GithubParser> = mapOf(
        DOTTY to DottyGithubParser(),
        SWIFT to SwiftGithubParser(),
    )

    suspend fun getLatestVersions(vararg langs: Language = values()): Map<Language, Release?> {
        val htmlReleases = GlobalScope.async {
            langs
                .filter(parsers::containsKey)
                .map {
                    val url = Languages.releasesUrl[it]
                    it to async { parsers[it]?.parse(url?.connect()) }
                }
                .map { (lang, deferred) -> lang to deferred.await() }
                .toMap()
        }
        val githubReleases = GlobalScope.async {
            langs
                .filter(gitHubParsers::containsKey)
                .map {
                    it to async { gitHubParsers[it]?.parse() }
                }
                .map { (lang, deferred) -> lang to deferred.await() }
                .toMap()
        }
        return htmlReleases.await() + githubReleases.await()
    }

    fun invalidateCache() {
        gitHubParsers.forEach { (_, value) -> value.invalidateCache() }
    }

    private fun String.connect(): Document? {
        return try {
            Jsoup.connect(this).get()
        } catch (e: Exception) {
            //handle exceptions here
            println("Sth bad happened : ${e.message}")
            null
        }
    }
}

suspend fun String?.getLatestVersions() = this
    ?.split(",")
    ?.map {it.toUpperCase(Locale.ROOT)}
    ?.filter { Language.values().map(Language::name).contains(it) }
    ?.map { valueOf(it) }
    .let { Scrapper.getLatestVersions(*it?.toTypedArray() ?: values()) }

suspend fun String?.getFullVersionsTable() = this.getLatestVersions()
    .map { (lang, release) ->
        ReleaseRecord(lang, Languages.supportedVersions[lang] ?: "",
            release?.version ?: "", release?.notes?.getOrElse(0) { "" } ?: "")
    }
