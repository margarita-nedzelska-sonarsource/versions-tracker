package com.example.versions

import assertk.assertThat
import assertk.assertions.isLessThan
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

class TestParsingTime {
    @Test
    fun testAllLatestVersions() = runBlocking {
        val javaTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.JAVA)
        }
        println("Java time  : $javaTime ns")

        val kotlinTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.KOTLIN)
        }
        println("Kotlin time: $kotlinTime ns")

        val scalaTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.SCALA)
        }
        println("Scala time : $scalaTime ns")

        val goTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.GO)
        }
        println("Go time    : $goTime ns")

        val rubyTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.RUBY)
        }
        println("Ruby time  : $rubyTime ns")

        val swiftTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.SWIFT)
        }
        println("Swift time : $swiftTime ns")

        val dottyTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.DOTTY)
        }
        println("Dotty time : $dottyTime ns")

        val allTime = measureNanoTime {
            Scrapper.getLatestVersions()
        }
        println("All time   : $allTime ns")

        assertThat(allTime).isLessThan(javaTime + kotlinTime + scalaTime + goTime + rubyTime + swiftTime)
    }

}