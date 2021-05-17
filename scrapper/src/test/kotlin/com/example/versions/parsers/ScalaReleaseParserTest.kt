package com.example.versions.parsers

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class ScalaReleaseParserTest {
    
    val doc: Document = Jsoup.parse(File("src/test/resources/scala.html"), "UTF-8")
    
    @Test
    fun testGetVersion() {
        val scalaReleaseParser = ScalaReleaseParser()

        val (version, notes) = scalaReleaseParser.parse(doc)
        
        assertEquals("2.13.6", version)
        assertEquals(listOf("github.com/scala/scala/releases/tag/v2.13.6"), notes)
    }
}
