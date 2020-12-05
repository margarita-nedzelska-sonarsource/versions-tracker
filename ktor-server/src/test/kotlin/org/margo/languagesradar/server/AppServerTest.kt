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
                assertEquals(
                    """
                    {
                      $JAVA_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testScalaVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Scala")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $SCALA_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testKotlinVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Kotlin")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $KOTLIN_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testAllLatestVersions() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
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
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testAllVersions() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/versions")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """[ $JAVA_RELEASE_RECORD, $KOTLIN_RELEASE_RECORD, $SCALA_RELEASE_RECORD, $GO_RELEASE_RECORD, $RUBY_RELEASE_RECORD, $APEX_RELEASE_RECORD, $SWIFT_RELEASE_RECORD, $DOTTY_RELEASE_RECORD ]"""
                        .trimIndent(), response.content
                )
            }
        }
    }
}