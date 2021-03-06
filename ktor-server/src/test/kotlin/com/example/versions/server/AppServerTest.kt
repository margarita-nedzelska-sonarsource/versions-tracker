package com.example.versions.server

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
    fun testRubyVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Ruby")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $RUBY_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testGoVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Go")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $GO_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testSwiftVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Swift")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $SWIFT_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testDottyVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Dotty")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $DOTTY_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testScalametaVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=Scala_Meta")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $SCALA_META_RELEASE
                    }
                """.trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testJDTVersion() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/latest?langs=jdt")) {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """
                    {
                      $JDT_RELEASE
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
                      $SCALA_RELEASE,
                      $GO_RELEASE,
                      $RUBY_RELEASE,
                      $JDT_RELEASE,
                      $KOTLIN_RELEASE,
                      $SWIFT_RELEASE,
                      $DOTTY_RELEASE,
                      $SCALA_META_RELEASE
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
                    """[ $JAVA_RELEASE_RECORD, $SCALA_RELEASE_RECORD, $GO_RELEASE_RECORD, $RUBY_RELEASE_RECORD, $JDT_RELEASE_RECORD, $KOTLIN_RELEASE_RECORD, $SWIFT_RELEASE_RECORD, $DOTTY_RELEASE_RECORD, $SCALA_META_RELEASE_RECORD ]"""
                        .trimIndent(), response.content
                )
            }
        }
    }

    @Test
    fun testViewVersions() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/view/versions")) {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}