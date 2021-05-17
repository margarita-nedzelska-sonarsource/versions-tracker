package com.example.versions

import assertk.assertThat
import assertk.assertions.containsOnly
import com.example.versions.Languages.LATEST_KNOWN_VERSIONS
import com.example.versions.Project.*
import com.example.versions.parsers.Release
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.io.IOException
import java.nio.charset.Charset

class ScrapperTest {
    
    @Test
    fun testJavaLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(JAVA)
        
        assertThat(latestVersions).containsOnly(
                JAVA to Release(LATEST_KNOWN_VERSIONS[JAVA]!!, listOf("oracle.com/java/technologies/javase/16u-relnotes.html"))
        )
    }

    @Test
    fun testKotlinLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(KOTLIN)
        
        assertThat(latestVersions).containsOnly(
                KOTLIN to Release(LATEST_KNOWN_VERSIONS[KOTLIN]!!, listOf("https://github.com/JetBrains/kotlin/releases/tag/v1.5.0"))
        )
    }

    @Test
    fun testScalaLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(SCALA)
        
        assertThat(latestVersions).containsOnly(
                SCALA to Release(LATEST_KNOWN_VERSIONS[SCALA]!!, listOf("github.com/scala/scala/releases/tag/v2.13.6"))
        )
    }

    @Test
    fun testGoLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(GO)
        
        assertThat(latestVersions).containsOnly(
                GO to Release(LATEST_KNOWN_VERSIONS[GO]!!, listOf("golang.org/doc/go1.16"))
        )
    }

    @Test
    fun testRubyLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(RUBY)
        
        assertThat(latestVersions).containsOnly(
                RUBY to Release(LATEST_KNOWN_VERSIONS[RUBY]!!, listOf("www.ruby-lang.org/en/news/2021/04/05/ruby-3-0-1-released/"))
        )
    }
    
    @Test
    fun testSwiftLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(SWIFT)
        
        assertThat(latestVersions).containsOnly(
                SWIFT to Release(LATEST_KNOWN_VERSIONS[SWIFT]!!, listOf("https://github.com/apple/swift/releases/tag/swift-5.4-RELEASE"))
        )
    }
    
    @Test
    fun testDottyLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(DOTTY)

        assertThat(latestVersions).containsOnly(
                DOTTY to Release(LATEST_KNOWN_VERSIONS[DOTTY]!!, listOf("https://github.com/lampepfl/dotty/releases/tag/3.0.0"))
        )
    }

    @Test
    fun testScalaMetaLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(SCALA_META)

        assertThat(latestVersions).containsOnly(
            SCALA_META to Release(LATEST_KNOWN_VERSIONS[SCALA_META]!!, listOf("https://github.com/scalameta/scalameta/releases/tag/v4.4.18"))
        )
    }

    @Test
    fun testEclipseJDTLatestRelease() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(JDT)

        assertThat(latestVersions).containsOnly(
            JDT to Release(LATEST_KNOWN_VERSIONS[JDT]!!, listOf("https://git.eclipse.org/r/plugins/gitiles/jdt/eclipse.jdt.core/+/refs/tags/R4_19"))
        )
    }

    @Test
    fun testAllLatestVersions() = runBlocking {
        val latestVersions = Scrapper.getLatestVersions(JAVA, KOTLIN, SCALA, GO, RUBY, SWIFT, DOTTY, SCALA_META, JDT)
        
        assertThat(latestVersions.map { (k, v) -> k to v?.version })
                .containsOnly(
                        JAVA to LATEST_KNOWN_VERSIONS[JAVA],
                        KOTLIN to LATEST_KNOWN_VERSIONS[KOTLIN],
                        SCALA to LATEST_KNOWN_VERSIONS[SCALA],
                        GO to LATEST_KNOWN_VERSIONS[GO],
                        RUBY to LATEST_KNOWN_VERSIONS[RUBY],
                        SWIFT to LATEST_KNOWN_VERSIONS[SWIFT],
                        DOTTY to LATEST_KNOWN_VERSIONS[DOTTY],
                        SCALA_META to LATEST_KNOWN_VERSIONS[SCALA_META],
                        JDT to LATEST_KNOWN_VERSIONS[JDT],
                )
    }
}

open class Parent {
    fun foo(): Unit = TODO()
}

class Outer {
    fun foo(): Unit = TODO()

    inner class Inner: Parent() {

        fun doSth() {
            try {
                "".toString()
                TODO()
            } catch (e: IOException) {
                print(e)
            } catch (e: RuntimeException) {
                print(e)
            }

            this@Outer.foo()
        }

    }
}
