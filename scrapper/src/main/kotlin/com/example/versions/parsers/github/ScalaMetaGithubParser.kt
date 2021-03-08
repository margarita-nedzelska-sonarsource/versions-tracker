package com.example.versions.parsers.github

import com.example.versions.parsers.Release

class ScalaMetaGithubParser : GithubParser {
    private val repoName = "scalameta/scalameta"
    private val versionRegex = Regex("v(\\d{1,2}\\.\\d{1,2}(\\.\\d{1,2})?)")

    private var latest: Release? = null

    override fun parse(): Release {
        latest = latest?: getLatest(repoName, versionRegex)
        return latest!!
    }

    override fun invalidateCache() {
        latest = null
    }

}