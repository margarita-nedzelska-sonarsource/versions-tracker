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
            Scrapper.getLatestVersions(Project.JAVA)
        }
        println("Java time  : $javaTime ns")

        val kotlinTime = measureNanoTime {
            Scrapper.getLatestVersions(Project.KOTLIN)
        }
        println("Kotlin time: $kotlinTime ns")

        val scalaTime = measureNanoTime {
            Scrapper.getLatestVersions(Project.SCALA)
        }
        println("Scala time : $scalaTime ns")

        val goTime = measureNanoTime {
            Scrapper.getLatestVersions(Project.GO)
        }
        println("Go time    : $goTime ns")

        val rubyTime = measureNanoTime {
            Scrapper.getLatestVersions(Project.RUBY)
        }
        println("Ruby time  : $rubyTime ns")

        val swiftTime = measureNanoTime {
            Scrapper.getLatestVersions(Project.SWIFT)
        }
        println("Swift time : $swiftTime ns")

        val dottyTime = measureNanoTime {
            Scrapper.getLatestVersions(Project.DOTTY)
        }
        println("Dotty time : $dottyTime ns")

        val allTime = measureNanoTime {
            Scrapper.getLatestVersions()
        }
        println("All time   : $allTime ns")

        assertThat(allTime).isLessThan(javaTime + kotlinTime + scalaTime + goTime + rubyTime + swiftTime)
    }

}