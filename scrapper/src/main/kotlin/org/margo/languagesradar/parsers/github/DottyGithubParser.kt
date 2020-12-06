package org.margo.languagesradar.parsers.github

import org.margo.languagesradar.parsers.Release

class DottyGithubParser : GithubParser {
    private val repoName = "lampepfl/dotty"
    private val versionRegex = Regex("\\d{1,2}\\.\\d{1,2}(\\.\\d{1,2})?")

    private var latest: Release? = null

    override fun parse(): Release =
        latest?: getLatest()

    override fun invalidateCache() {
        latest = null
    }

    private fun getLatest(): Release {
        val release = GithubHelper.getReleases(repoName)
        .firstOrNull { it.version.matches(versionRegex) } ?: Release.EMPTY_RELEASE
        latest = release
        return release
    }
}