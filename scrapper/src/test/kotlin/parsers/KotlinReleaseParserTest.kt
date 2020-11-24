package org.margo.languagesradar.parsers

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class KotlinReleaseParserTest {
    
    val doc: Document = Jsoup.parse(File("src/test/resources/kotlin.html"), "UTF-8")
    
    @Test
    fun testGetVersion() {
        val javaReleaseParser = KotlinReleaseParser()

        val (version, notes) = javaReleaseParser.parse(doc)
        
        assertEquals("1.4.20", version)
        assertEquals(listOf("kotlinlang.org/releases.html"), notes)
    }
}
