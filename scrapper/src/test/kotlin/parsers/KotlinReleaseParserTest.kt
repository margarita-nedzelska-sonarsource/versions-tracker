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
        val kotlinReleaseParser = KotlinReleaseParser()

        val (version, notes) = kotlinReleaseParser.parse(doc)
        
        assertEquals("1.4.20", version)
        assertEquals(listOf("kotlinlang.org/releases.html"), notes)
    }
}
