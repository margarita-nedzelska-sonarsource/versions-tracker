package com.example.versions.parsers

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class JDTReleaseParserTest {
    
    
    val doc: Document = Jsoup.parse(File("src/test/resources/jdt.html"), "UTF-8")
    
    @Test
    fun testGetVersion() {
        val jdtReleaseParser = JDTReleaseParser()

        val (version, notes) = jdtReleaseParser.parse(doc)
        
        assertEquals("4.18", version)
        assertEquals(listOf("https://git.eclipse.org/r/plugins/gitiles/jdt/eclipse.jdt.core/+/refs/tags/R4_18"), notes)
    }
}
