package com.example.versions.parsers.github

import com.example.versions.parsers.Release

class KotlinGithubParser : GithubParser {
    private val repoName = "JetBrains/kotlin"
    private val versionRegex = Regex("v(\\d{1,2}\\.\\d{1,2}(\\.\\d{1,2})?)")

    private var latest: Release? = null

    override fun parse(): Release =
        latest?: getLatest()

    override fun invalidateCache() {
        latest = null
    }

    private fun getLatest(): Release {
        val release = GithubHelper.getReleases(repoName)
            .filter { it.version.matches(versionRegex) }
            .map { Release(versionRegex.find(it.version)!!.groups[1]!!.value, it.notes) }
            .firstOrNull() ?: Release.EMPTY_RELEASE

        latest = release
        return release
    }
}