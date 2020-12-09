package com.example.versions.parsers.github

import com.example.versions.parsers.Release

interface GithubParser {
    fun parse(): Release

    fun invalidateCache()
}