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
                assertEquals("""
                    {
                      "JAVA" : {
                        "version" : "15",
                        "notes" : [ "oracle.com/java/technologies/javase/15u-relnotes.html" ]
                      }
                    }
                """.trimIndent(), response.content)
            }
        }
    }
    @Test
    fun testAllVersions() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("""
                    {
                      "JAVA" : {
                        "version" : "15",
                        "notes" : [ "oracle.com/java/technologies/javase/15u-relnotes.html" ]
                      },
                      "KOTLIN" : {
                        "version" : "1.4.20",
                        "notes" : [ "kotlinlang.org/releases.html" ]
                      },
                      "SCALA" : {
                        "version" : "2.13.4",
                        "notes" : [ "github.com/scala/scala/releases/tag/v2.13.4" ]
                      },
                      "GO" : {
                        "version" : "1.15",
                        "notes" : [ "golang.org/doc/go1.15" ]
                      },
                      "RUBY" : {
                        "version" : "2.7.2",
                        "notes" : [ "www.ruby-lang.org/en/news/2020/10/02/ruby-2-7-2-released/" ]
                      },
                      "APEX" : null,
                      "SWIFT" : {
                        "version" : "5.3.1",
                        "notes" : [ "https://github.com/apple/swift/releases/tag/swift-5.3.1-RELEASE" ]
                      },
                      "DOTTY" : null
                    }
                """.trimIndent(), response.content)
            }
        }
    }
}