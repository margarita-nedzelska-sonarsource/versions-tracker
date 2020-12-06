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
import org.margo.languagesradar.Language
import org.margo.languagesradar.Languages
import org.margo.languagesradar.Scrapper
import org.margo.languagesradar.server.data.ReleaseRecord
import org.margo.languagesradar.server.html.toHtml
import java.util.*

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
    }
}

private suspend fun String?.getLatestVersions() = this
    ?.split(",")
    ?.map { Language.valueOf(it.toUpperCase(Locale.ROOT)) }
    .let { Scrapper.getLatestVersions(*it?.toTypedArray() ?: Language.values()) }

private suspend fun String?.getFullVersionsTable() = this.getLatestVersions()
    .map { (lang, release) ->
        ReleaseRecord(lang, Languages.supportedVersions[lang] ?: "",
            release?.version ?: "", release?.notes?.getOrElse(0) { "" } ?: "")
    }
