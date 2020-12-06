package org.margo.languagesradar.parsers.github

import org.margo.languagesradar.parsers.Release

interface GithubParser {
    fun parse(): Release
}