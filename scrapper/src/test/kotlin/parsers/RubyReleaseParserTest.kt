package org.margo.languagesradar.parsers

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class RubyReleaseParserTest {
    
    val doc: Document = Jsoup.parse(File("src/test/resources/ruby.html"), "UTF-8")
    
    @Test
    fun testGetVersion() {
        val rubyReleaseParser = RubyReleaseParser()

        val (version, notes) = rubyReleaseParser.parse(doc)
        
        assertEquals("2.7.2", version)
        assertEquals(listOf("www.ruby-lang.org/en/news/2020/10/02/ruby-2-7-2-released/"), notes)
    }
}
