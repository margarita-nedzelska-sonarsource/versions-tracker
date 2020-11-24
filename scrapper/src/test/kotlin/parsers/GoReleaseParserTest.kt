package org.margo.languagesradar.parsers

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class GoReleaseParserTest {
    
    val doc: Document = Jsoup.parse(File("src/test/resources/go.html"), "UTF-8")
    
    @Test
    fun testGetVersion() {
        val goReleaseParser = GoReleaseParser()

        val (version, notes) = goReleaseParser.parse(doc)
        
        assertEquals("1.15", version)
        assertEquals(listOf("golang.org/doc/go1.15"), notes)
    }
}
