package com.example.versions

import assertk.assertThat
import assertk.assertions.containsOnly
import com.example.versions.Language.*
import com.example.versions.Languages.latestKnownVersions
import com.example.versions.parsers.Release
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ScrapperTest {
    
    @Test
    fun testJavaLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(JAVA)
        
        assertThat(latestVersions).containsOnly(
                JAVA to Release(latestKnownVersions[JAVA]!!, listOf("oracle.com/java/technologies/javase/15u-relnotes.html"))
        )
    }

    @Test
    fun testKotlinLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(KOTLIN)
        
        assertThat(latestVersions).containsOnly(
                KOTLIN to Release(latestKnownVersions[KOTLIN]!!, listOf("https://github.com/JetBrains/kotlin/releases/tag/v1.4.30"))
        )
    }

    @Test
    fun testScalaLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(SCALA)
        
        assertThat(latestVersions).containsOnly(
                SCALA to Release(latestKnownVersions[SCALA]!!, listOf("github.com/scala/scala/releases/tag/v2.13.4"))
        )
    }

    @Test
    fun testGoLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(GO)
        
        assertThat(latestVersions).containsOnly(
                GO to Release(latestKnownVersions[GO]!!, listOf("golang.org/doc/go1.16"))
        )
    }

    @Test
    fun testRubyLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(RUBY)
        
        assertThat(latestVersions).containsOnly(
                RUBY to Release(latestKnownVersions[RUBY]!!, listOf("www.ruby-lang.org/en/news/2020/12/25/ruby-3-0-0-released/"))
        )
    }
    
    @Test
    fun testSwiftLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(SWIFT)
        
        assertThat(latestVersions).containsOnly(
                SWIFT to Release(latestKnownVersions[SWIFT]!!, listOf("https://github.com/apple/swift/releases/tag/swift-5.3.3-RELEASE"))
        )
    }
    
    @Test
    fun testDottyLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(DOTTY)

        assertThat(latestVersions).containsOnly(
                DOTTY to Release(latestKnownVersions[DOTTY]!!, listOf("https://github.com/lampepfl/dotty/releases/tag/0.26.0"))
        )
    }

    @Test
    fun testAllLatestVersions() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(JAVA, KOTLIN, SCALA, GO, RUBY, SWIFT, DOTTY)
        
        assertThat(latestVersions.map { (k, v) -> k to v?.version })
                .containsOnly(
                        JAVA to latestKnownVersions[JAVA],
                        KOTLIN to latestKnownVersions[KOTLIN],
                        SCALA to latestKnownVersions[SCALA],
                        GO to latestKnownVersions[GO],
                        RUBY to latestKnownVersions[RUBY],
                        SWIFT to latestKnownVersions[SWIFT],
                        DOTTY to latestKnownVersions[DOTTY],
                )
    }
}