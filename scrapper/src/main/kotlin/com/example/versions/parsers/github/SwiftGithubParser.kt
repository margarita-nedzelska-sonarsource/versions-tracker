package com.example.versions.parsers.github

import com.example.versions.parsers.Release

class SwiftGithubParser : GithubParser {
    private val repoName = "apple/swift"
    private val releaseVersion = Regex("swift-(\\d\\.\\d(\\.\\d)?)-RELEASE")
    private var latest: Release? = null

    override fun parse(): Release =
        latest ?: getLatest()

    override fun invalidateCache() {
        latest = null
    }

    private fun getLatest(): Release {
        val release = GithubHelper.getReleases(repoName)
            .asSequence()
            .filter { it.version.matches(releaseVersion) }
            .map { Release(releaseVersion.find(it.version)!!.groups[1]!!.value, it.notes) }
            .firstOrNull() ?: Release.EMPTY_RELEASE
        latest = release
        return release
    }
}