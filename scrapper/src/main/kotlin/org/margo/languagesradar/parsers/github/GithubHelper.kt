package org.margo.languagesradar.parsers.github

import org.kohsuke.github.GitHub
import org.margo.languagesradar.parsers.Release

object GithubHelper {
    val gitHub: GitHub = GitHub.connectUsingOAuth(System.getenv("GITHUB_TOKEN"))

    fun getReleases(repo: String) : List<Release> {
        val repository = gitHub.getRepository(repo)
        return repository.listReleases().map { Release(it.tagName, listOf(it.htmlUrl.toString())) }
    }
}