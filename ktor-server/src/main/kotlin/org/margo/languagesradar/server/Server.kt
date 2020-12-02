package org.margo.languagesradar.server

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.margo.languagesradar.Language
import org.margo.languagesradar.Scrapper
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
            val result =
                call.parameters["langs"]
                    ?.split(",")
                    ?.map {
                        Language.valueOf(it.toUpperCase(Locale.ROOT))
                    }
                    .let {
                        Scrapper.getLatestVersions(*it?.toTypedArray() ?: Language.values())
                    }
            call.respond(result)
        }
    }
}

