package org.margo.languagesradar

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
        val kotlinTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.KOTLIN)
        }
        val scalaTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.SCALA)
        }
        val goTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.GO)
        }
        val rubyTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.RUBY)
        }
        val swiftTime = measureNanoTime {
            Scrapper.getLatestVersions(Language.SWIFT)
        }
        val allTime = measureNanoTime {
            Scrapper.getLatestVersions()
        }

        println("Java time  : $javaTime ns")
        println("Kotlin time: $kotlinTime ns")
        println("Scala time : $scalaTime ns")
        println("Go time    : $goTime ns")
        println("Ruby time  : $rubyTime ns")
        println("Swift time : $swiftTime ns")

        println("All time   : $allTime ns")

        assertThat(allTime).isLessThan(javaTime + kotlinTime + scalaTime + goTime + rubyTime + swiftTime)
    }

}