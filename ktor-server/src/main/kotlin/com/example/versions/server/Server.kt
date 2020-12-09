package com.example.versions.server

import com.example.versions.Scrapper
import com.example.versions.getFullVersionsTable
import com.example.versions.getLatestVersions
import com.example.versions.html.toHtml
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        main()
    }
    server.start(wait = true)
}

fun Application.main() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
        }
        get(path = "/latest") {
            call.respond(call.parameters["langs"].getLatestVersions())
        }
        get(path = "/versions") {
            call.respond(call.parameters["langs"].getFullVersionsTable())
        }
        get(path = "/view/versions") {
            val result = call.parameters["langs"].getFullVersionsTable()
            call.respondHtml { toHtml(result) }
        }
        post(path = "/invalidate") {
            Scrapper.invalidateCache()
            call.respondText("Cache invalidated!")
        }

    }
}
