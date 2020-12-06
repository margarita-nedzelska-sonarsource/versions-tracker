package org.margo.languagesradar.parsers.github

import org.margo.languagesradar.parsers.Release

class DottyGithubParser : GithubParser {
    private val repoName = "lampepfl/dotty"
    private val versionRegex = Regex("\\d{1,2}\\.\\d{1,2}(\\.\\d{1,2})?")

    override fun parse(): Release {
        return GithubHelper.getReleases(repoName)
            .firstOrNull { it.version.matches(versionRegex) } ?: Release.EMPTY_RELEASE
    }
}