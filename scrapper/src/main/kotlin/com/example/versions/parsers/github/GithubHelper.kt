package com.example.versions.parsers.github

import com.example.versions.parsers.Release
import org.kohsuke.github.GitHub

object GithubHelper {
    val gitHub: GitHub = GitHub.connectUsingOAuth(System.getenv("GITHUB_TOKEN"))

    fun getReleases(repo: String) : List<Release> {
        val repository = gitHub.getRepository(repo)
        return repository.listReleases().map { Release(it.tagName, listOf(it.htmlUrl.toString())) }
    }
}