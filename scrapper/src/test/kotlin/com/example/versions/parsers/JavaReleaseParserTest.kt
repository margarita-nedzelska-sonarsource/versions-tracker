package com.example.versions.parsers

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class JavaReleaseParserTest {
    
    
    val doc: Document = Jsoup.parse(File("src/test/resources/java.html"), "UTF-8")
    
    @Test
    fun testGetVersion() {
        val javaReleaseParser = JavaReleaseParser()

        val (version, notes) = javaReleaseParser.parse(doc)
        
        assertEquals("15", version)
        assertEquals(listOf("oracle.com/java/technologies/javase/15u-relnotes.html"), notes)
    }
}
