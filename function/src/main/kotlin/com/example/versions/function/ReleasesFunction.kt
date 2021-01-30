package com.example.versions.function

import com.example.versions.Scrapper
import com.example.versions.getFullVersionsTable
import com.example.versions.getLatestVersions
import com.example.versions.html.toHtml
import com.google.cloud.functions.HttpFunction
import com.google.cloud.functions.HttpRequest
import com.google.cloud.functions.HttpResponse
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.IOException

fun main() {
    // to not fail ./gradlew run from the root
}

class ReleasesFunction : HttpFunction {
    private val gson = Gson()

    @Throws(IOException::class)
    override fun service(request: HttpRequest, response: HttpResponse) {
        runBlocking {
            when (request.path) {
                "/latest" -> {
                    val latestVersions = request.queryParameters["langs"]?.first().getLatestVersions()
                    response.setContentType("application/json")
                    response.writer.write(gson.toJson(latestVersions))
                }
                "/versions" -> {
                    val latestVersions = request.queryParameters["langs"]?.first().getFullVersionsTable()
                    response.setContentType("application/json")
                    response.writer.write(gson.toJson(latestVersions))
                }
                "/view/versions" -> {
                    response.setContentType("text/html")
                    val latestVersions = request.queryParameters["langs"]?.first().getFullVersionsTable()
                    response.writer.appendHTML().html { toHtml(latestVersions) }
                }
                "/invalidate" -> {
                    Scrapper.invalidateCache()
                    response.writer.write("Cache cleared!")
                }
                else -> response.writer.write("Hello World!")
            }
        }
    }
}
