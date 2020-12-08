package org.margo.languagesradar.function

import com.google.cloud.functions.HttpFunction
import com.google.cloud.functions.HttpRequest
import com.google.cloud.functions.HttpResponse
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import org.margo.languagesradar.getFullVersionsTable
import org.margo.languagesradar.getLatestVersions
import java.io.IOException

class ReleasesFunction : HttpFunction {
    private val gson = Gson();
    @Throws(IOException::class)
    override fun service(request: HttpRequest, response: HttpResponse) = runBlocking {
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
        }
    }
}