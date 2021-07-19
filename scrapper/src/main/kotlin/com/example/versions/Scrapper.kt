package com.example.versions

import com.example.versions.Project.*
import com.example.versions.data.ReleaseRecord
import com.example.versions.parsers.*
import com.example.versions.parsers.github.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

suspend fun main() {
    val latestVersions = Scrapper.getLatestVersions(SCALA, JAVA, KOTLIN, GO, RUBY, SWIFT, DOTTY)
    latestVersions.forEach(::println)
}

object Scrapper {
    private val PARSERS: Map<Project, ReleaseParser> = mapOf(
        JAVA to JavaReleaseParser(),
        SCALA to ScalaReleaseParser(),
        GO to GoReleaseParser(),
        RUBY to RubyReleaseParser(),
        JDT to JDTReleaseParser(),
    )

    private val GIT_HUB_PARSERS: Map<Project, GithubParser> = mapOf(
        DOTTY to DottyGithubParser(),
        SWIFT to SwiftGithubParser(),
        KOTLIN to KotlinGithubParser(),
        SCALA_META to ScalaMetaGithubParser(),
    )

    suspend fun getLatestVersions(vararg langs: Project = values()): Map<Project, Release?> {
        val htmlReleases = GlobalScope.async {
            langs
                .filter(PARSERS::containsKey)
                .map {
                    val url = Languages.RELEASES_URL[it]
                    it to async { PARSERS[it]?.parse(url?.connect()) }
                }.associate { (lang, deferred) -> lang to deferred.await() }
        }
        val githubReleases = GlobalScope.async {
            langs
                .filter(GIT_HUB_PARSERS::containsKey)
                .map {
                    it to async { GIT_HUB_PARSERS[it]?.parse() }
                }.associate { (lang, deferred) -> lang to deferred.await() }
        }
        return htmlReleases.await() + githubReleases.await()
    }

    fun invalidateCache() {
        GIT_HUB_PARSERS.forEach { (_, value) -> value.invalidateCache() }
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
    ?.map { it.uppercase() }
    ?.filter { Project.values().map(Project::name).contains(it) }
    ?.map { valueOf(it) }
    .let { Scrapper.getLatestVersions(*it?.toTypedArray() ?: values()) }

suspend fun String?.getFullVersionsTable() = this.getLatestVersions()
    .map { (lang, release) ->
        ReleaseRecord(lang, Languages.SUPPORTED_VERSIONS[lang] ?: "",
            release?.version ?: "", release?.notes?.getOrElse(0) { "" } ?: "")
    }
