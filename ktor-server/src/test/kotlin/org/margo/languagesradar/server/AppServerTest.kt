package org.margo.languagesradar.server

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppServerTest {

    private val JAVA_RELEASE =
        """"JAVA" : {
                        "version" : "15",
                        "notes" : [ "oracle.com/java/technologies/javase/15u-relnotes.html" ]
                      }"""

    private val KOTLIN_RELEASE =
        """"KOTLIN" : {
                        "version" : "1.4.20",
                        "notes" : [ "kotlinlang.org/releases.html" ]
                      }"""

    private val SCALA_RELEASE =
        """"SCALA" : {
                        "version" : "2.13.4",
                        "notes" : [ "github.com/scala/scala/releases/tag/v2.13.4" ]
                      }"""

    private val GO_RELEASE =
        """"GO" : {
                        "version" : "1.15",
                        "notes" : [ "golang.org/doc/go1.15" ]
                      }"""

    private val RUBY_RELEASE =
        """"RUBY" : {
                        "version" : "2.7.2",
                        "notes" : [ "www.ruby-lang.org/en/news/2020/10/02/ruby-2-7-2-released/" ]
                      }"""

    private val SWIFT_RELEASE =
        """"SWIFT" : {
                        "version" : "5.3.1",
                        "notes" : [ "https://github.com/apple/swift/releases/tag/swift-5.3.1-RELEASE" ]
                      }"""


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
                      $JAVA_RELEASE
                    }
                """.trimIndent(), response.content)
            }
        }
    }

    @Test
    fun testScalaVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Scala")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("""
                    {
                      $SCALA_RELEASE
                    }
                """.trimIndent(), response.content)
            }
        }
    }

    @Test
    fun testKotlinVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Kotlin")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("""
                    {
                      $KOTLIN_RELEASE
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
                      $JAVA_RELEASE,
                      $KOTLIN_RELEASE,
                      $SCALA_RELEASE,
                      $GO_RELEASE,
                      $RUBY_RELEASE,
                      "APEX" : null,
                      $SWIFT_RELEASE,
                      "DOTTY" : null
                    }
                """.trimIndent(), response.content)
            }
        }
    }
}