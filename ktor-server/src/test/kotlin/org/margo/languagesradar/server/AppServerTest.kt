package org.margo.languagesradar.server

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppServerTest {

    @Test
    fun testHelloWorld() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }

    @Test
    fun testJavaVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Java")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("{\n" +
                        "  \"JAVA\" : {\n" +
                        "    \"version\" : \"15\",\n" +
                        "    \"notes\" : [ \"oracle.com/java/technologies/javase/15u-relnotes.html\" ]\n" +
                        "  }\n" +
                        "}", response.content)
            }
        }
    }
    @Test
    fun testAllVersions() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("{\n" +
                        "  \"JAVA\" : {\n" +
                        "    \"version\" : \"15\",\n" +
                        "    \"notes\" : [ \"oracle.com/java/technologies/javase/15u-relnotes.html\" ]\n" +
                        "  },\n" +
                        "  \"KOTLIN\" : {\n" +
                        "    \"version\" : \"1.4.20\",\n" +
                        "    \"notes\" : [ \"kotlinlang.org/releases.html\" ]\n" +
                        "  },\n" +
                        "  \"SCALA\" : {\n" +
                        "    \"version\" : \"2.13.4\",\n" +
                        "    \"notes\" : [ \"github.com/scala/scala/releases/tag/v2.13.4\" ]\n" +
                        "  },\n" +
                        "  \"GO\" : {\n" +
                        "    \"version\" : \"1.15\",\n" +
                        "    \"notes\" : [ \"golang.org/doc/go1.15\" ]\n" +
                        "  },\n" +
                        "  \"RUBY\" : {\n" +
                        "    \"version\" : \"2.7.2\",\n" +
                        "    \"notes\" : [ \"www.ruby-lang.org/en/news/2020/10/02/ruby-2-7-2-released/\" ]\n" +
                        "  },\n" +
                        "  \"APEX\" : null,\n" +
                        "  \"SWIFT\" : {\n" +
                        "    \"version\" : \"5.3.1\",\n" +
                        "    \"notes\" : [ \"https://github.com/apple/swift/releases/tag/swift-5.3.1-RELEASE\" ]\n" +
                        "  },\n" +
                        "  \"DOTTY\" : null\n" +
                        "}", response.content)
            }
        }
    }
}