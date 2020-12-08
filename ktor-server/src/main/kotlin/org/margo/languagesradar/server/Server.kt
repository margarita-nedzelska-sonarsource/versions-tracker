package org.margo.languagesradar.server

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
import org.margo.languagesradar.Scrapper
import org.margo.languagesradar.getLatestVersions
import org.margo.languagesradar.getFullVersionsTable
import org.margo.languagesradar.server.html.toHtml

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
