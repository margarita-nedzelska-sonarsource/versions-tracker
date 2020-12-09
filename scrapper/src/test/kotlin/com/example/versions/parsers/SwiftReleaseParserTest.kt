package com.example.versions.parsers

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class SwiftReleaseParserTest {
    
    val doc: Document = Jsoup.parse(File("src/test/resources/swift.html"), "UTF-8")
    
    @Test
    fun testGetVersion() {
        val swiftReleaseParser = SwiftReleaseParser()

        val (version, notes) = swiftReleaseParser.parse(doc)
        
        assertEquals("5.3.1", version)
        assertEquals(listOf("https://github.com/apple/swift/releases/tag/swift-5.3.1-RELEASE"), notes)
    }
}
