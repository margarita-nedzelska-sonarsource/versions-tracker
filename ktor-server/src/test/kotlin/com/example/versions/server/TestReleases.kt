package com.example.versions.server

import com.example.versions.Project.*
import com.example.versions.Languages.LATEST_KNOWN_VERSIONS
import com.example.versions.Languages.SUPPORTED_VERSIONS

val JAVA_RELEASE =
    """"JAVA" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[JAVA]}",
                        "notes" : [ "oracle.com/java/technologies/javase/16u-relnotes.html" ]
                      }"""

val KOTLIN_RELEASE =
    """"KOTLIN" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[KOTLIN]}",
                        "notes" : [ "https://github.com/JetBrains/kotlin/releases/tag/v1.5.0" ]
                      }"""

val SCALA_RELEASE =
    """"SCALA" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[SCALA]}",
                        "notes" : [ "github.com/scala/scala/releases/tag/v2.13.5" ]
                      }"""

val GO_RELEASE =
    """"GO" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[GO]}",
                        "notes" : [ "golang.org/doc/go1.16" ]
                      }"""

val RUBY_RELEASE =
    """"RUBY" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[RUBY]}",
                        "notes" : [ "www.ruby-lang.org/en/news/2021/04/05/ruby-3-0-1-released/" ]
                      }"""

val SWIFT_RELEASE =
    """"SWIFT" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[SWIFT]}",
                        "notes" : [ "https://github.com/apple/swift/releases/tag/swift-5.4-RELEASE" ]
                      }"""

val DOTTY_RELEASE =
    """"DOTTY" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[DOTTY]}",
                        "notes" : [ "https://github.com/lampepfl/dotty/releases/tag/0.26.0" ]
                      }"""

val SCALA_META_RELEASE =
    """"SCALA_META" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[SCALA_META]}",
                        "notes" : [ "https://github.com/scalameta/scalameta/releases/tag/v4.4.16" ]
                      }"""

val JDT_RELEASE =
    """"JDT" : {
                        "version" : "${LATEST_KNOWN_VERSIONS[JDT]}",
                        "notes" : [ "https://git.eclipse.org/r/plugins/gitiles/jdt/eclipse.jdt.core/+/refs/tags/R4_19" ]
                      }"""

val JAVA_RELEASE_RECORD =
    """{
  "project" : "JAVA",
  "supportedVersion" : "${SUPPORTED_VERSIONS[JAVA]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[JAVA]}",
  "latestReleaseNote" : "oracle.com/java/technologies/javase/16u-relnotes.html"
}"""

val KOTLIN_RELEASE_RECORD = """{
  "project" : "KOTLIN",
  "supportedVersion" : "${SUPPORTED_VERSIONS[KOTLIN]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[KOTLIN]}",
  "latestReleaseNote" : "https://github.com/JetBrains/kotlin/releases/tag/v1.5.0"
}"""

val SCALA_RELEASE_RECORD = """{
  "project" : "SCALA",
  "supportedVersion" : "${SUPPORTED_VERSIONS[SCALA]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[SCALA]}",
  "latestReleaseNote" : "github.com/scala/scala/releases/tag/v2.13.5"
}"""

val GO_RELEASE_RECORD = """{
  "project" : "GO",
  "supportedVersion" : "${SUPPORTED_VERSIONS[GO]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[GO]}",
  "latestReleaseNote" : "golang.org/doc/go1.16"
}"""

val RUBY_RELEASE_RECORD = """{
  "project" : "RUBY",
  "supportedVersion" : "${SUPPORTED_VERSIONS[RUBY]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[RUBY]}",
  "latestReleaseNote" : "www.ruby-lang.org/en/news/2021/04/05/ruby-3-0-1-released/"
}"""

val SWIFT_RELEASE_RECORD = """{
  "project" : "SWIFT",
  "supportedVersion" : "${SUPPORTED_VERSIONS[SWIFT]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[SWIFT]}",
  "latestReleaseNote" : "https://github.com/apple/swift/releases/tag/swift-5.4-RELEASE"
}"""

val DOTTY_RELEASE_RECORD = """{
  "project" : "DOTTY",
  "supportedVersion" : "${SUPPORTED_VERSIONS[DOTTY]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[DOTTY]}",
  "latestReleaseNote" : "https://github.com/lampepfl/dotty/releases/tag/0.26.0"
}"""

val SCALA_META_RELEASE_RECORD = """{
  "project" : "SCALA_META",
  "supportedVersion" : "${SUPPORTED_VERSIONS[SCALA_META]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[SCALA_META]}",
  "latestReleaseNote" : "https://github.com/scalameta/scalameta/releases/tag/v4.4.16"
}"""

val JDT_RELEASE_RECORD = """{
  "project" : "JDT",
  "supportedVersion" : "${SUPPORTED_VERSIONS[JDT]}",
  "latestVersion" : "${LATEST_KNOWN_VERSIONS[JDT]}",
  "latestReleaseNote" : "https://git.eclipse.org/r/plugins/gitiles/jdt/eclipse.jdt.core/+/refs/tags/R4_19"
}"""
