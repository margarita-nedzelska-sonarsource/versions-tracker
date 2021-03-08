package com.example.versions.parsers.github

import com.example.versions.parsers.Release

interface GithubParser {
    fun parse(): Release

    fun invalidateCache()

    fun getLatest(repoName: String, versionRegex: Regex): Release =
        GithubHelper.getReleases(repoName)
            .asSequence()
            .filter { it.version.matches(versionRegex) }
            .map { Release(versionRegex.find(it.version)!!.groups[1]!!.value, it.notes) }
            .firstOrNull() ?: Release.EMPTY_RELEASE
}