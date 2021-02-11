package com.example.versions.server

import com.example.versions.Language.*
import com.example.versions.Languages.latestKnownVersions
import com.example.versions.Languages.supportedVersions

val JAVA_RELEASE =
    """"JAVA" : {
                        "version" : "${latestKnownVersions[JAVA]}",
                        "notes" : [ "oracle.com/java/technologies/javase/15u-relnotes.html" ]
                      }"""

val KOTLIN_RELEASE =
    """"KOTLIN" : {
                        "version" : "${latestKnownVersions[KOTLIN]}",
                        "notes" : [ "https://github.com/JetBrains/kotlin/releases/tag/v1.4.30" ]
                      }"""

val SCALA_RELEASE =
    """"SCALA" : {
                        "version" : "${latestKnownVersions[SCALA]}",
                        "notes" : [ "github.com/scala/scala/releases/tag/v2.13.4" ]
                      }"""

val GO_RELEASE =
    """"GO" : {
                        "version" : "${latestKnownVersions[GO]}",
                        "notes" : [ "golang.org/doc/go1.15" ]
                      }"""

val RUBY_RELEASE =
    """"RUBY" : {
                        "version" : "${latestKnownVersions[RUBY]}",
                        "notes" : [ "www.ruby-lang.org/en/news/2020/12/25/ruby-3-0-0-released/" ]
                      }"""

val SWIFT_RELEASE =
    """"SWIFT" : {
                        "version" : "${latestKnownVersions[SWIFT]}",
                        "notes" : [ "https://github.com/apple/swift/releases/tag/swift-5.3.3-RELEASE" ]
                      }"""

val DOTTY_RELEASE =
    """"DOTTY" : {
                        "version" : "${latestKnownVersions[DOTTY]}",
                        "notes" : [ "https://github.com/lampepfl/dotty/releases/tag/0.26.0" ]
                      }"""

val JAVA_RELEASE_RECORD =
    """{
  "language" : "JAVA",
  "supportedVersion" : "${supportedVersions[JAVA]}",
  "latestVersion" : "${latestKnownVersions[JAVA]}",
  "latestReleaseNote" : "oracle.com/java/technologies/javase/15u-relnotes.html"
}"""

val KOTLIN_RELEASE_RECORD = """{
  "language" : "KOTLIN",
  "supportedVersion" : "${supportedVersions[KOTLIN]}",
  "latestVersion" : "${latestKnownVersions[KOTLIN]}",
  "latestReleaseNote" : "https://github.com/JetBrains/kotlin/releases/tag/v1.4.30"
}"""

val SCALA_RELEASE_RECORD = """{
  "language" : "SCALA",
  "supportedVersion" : "${supportedVersions[SCALA]}",
  "latestVersion" : "${latestKnownVersions[SCALA]}",
  "latestReleaseNote" : "github.com/scala/scala/releases/tag/v2.13.4"
}"""

val GO_RELEASE_RECORD = """{
  "language" : "GO",
  "supportedVersion" : "${supportedVersions[GO]}",
  "latestVersion" : "${latestKnownVersions[GO]}",
  "latestReleaseNote" : "golang.org/doc/go1.15"
}"""

val RUBY_RELEASE_RECORD = """{
  "language" : "RUBY",
  "supportedVersion" : "${supportedVersions[RUBY]}",
  "latestVersion" : "${latestKnownVersions[RUBY]}",
  "latestReleaseNote" : "www.ruby-lang.org/en/news/2020/12/25/ruby-3-0-0-released/"
}"""

val SWIFT_RELEASE_RECORD = """{
  "language" : "SWIFT",
  "supportedVersion" : "${supportedVersions[SWIFT]}",
  "latestVersion" : "${latestKnownVersions[SWIFT]}",
  "latestReleaseNote" : "https://github.com/apple/swift/releases/tag/swift-5.3.3-RELEASE"
}"""

val DOTTY_RELEASE_RECORD = """{
  "language" : "DOTTY",
  "supportedVersion" : "${supportedVersions[DOTTY]}",
  "latestVersion" : "${latestKnownVersions[DOTTY]}",
  "latestReleaseNote" : "https://github.com/lampepfl/dotty/releases/tag/0.26.0"
}"""
