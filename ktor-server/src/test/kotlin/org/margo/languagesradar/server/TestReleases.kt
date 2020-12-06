package org.margo.languagesradar.server

val JAVA_RELEASE =
    """"JAVA" : {
                        "version" : "15",
                        "notes" : [ "oracle.com/java/technologies/javase/15u-relnotes.html" ]
                      }"""

val KOTLIN_RELEASE =
    """"KOTLIN" : {
                        "version" : "1.4.20",
                        "notes" : [ "kotlinlang.org/releases.html" ]
                      }"""

val SCALA_RELEASE =
    """"SCALA" : {
                        "version" : "2.13.4",
                        "notes" : [ "github.com/scala/scala/releases/tag/v2.13.4" ]
                      }"""

val GO_RELEASE =
    """"GO" : {
                        "version" : "1.15",
                        "notes" : [ "golang.org/doc/go1.15" ]
                      }"""

val RUBY_RELEASE =
    """"RUBY" : {
                        "version" : "2.7.2",
                        "notes" : [ "www.ruby-lang.org/en/news/2020/10/02/ruby-2-7-2-released/" ]
                      }"""

val SWIFT_RELEASE =
    """"SWIFT" : {
                        "version" : "5.3.1",
                        "notes" : [ "https://github.com/apple/swift/releases/tag/swift-5.3.1-RELEASE" ]
                      }"""

val DOTTY_RELEASE =
    """"DOTTY" : {
                        "version" : "0.26.0",
                        "notes" : [ "https://github.com/lampepfl/dotty/releases/tag/0.26.0" ]
                      }"""

val JAVA_RELEASE_RECORD =
    """{
  "language" : "JAVA",
  "supportedVersion" : "14",
  "latestVersion" : "15",
  "latestReleaseNote" : "oracle.com/java/technologies/javase/15u-relnotes.html"
}"""

val KOTLIN_RELEASE_RECORD = """{
  "language" : "KOTLIN",
  "supportedVersion" : "1.4",
  "latestVersion" : "1.4.20",
  "latestReleaseNote" : "kotlinlang.org/releases.html"
}"""

val SCALA_RELEASE_RECORD = """{
  "language" : "SCALA",
  "supportedVersion" : "2.13",
  "latestVersion" : "2.13.4",
  "latestReleaseNote" : "github.com/scala/scala/releases/tag/v2.13.4"
}"""

val GO_RELEASE_RECORD = """{
  "language" : "GO",
  "supportedVersion" : "1.15",
  "latestVersion" : "1.15",
  "latestReleaseNote" : "golang.org/doc/go1.15"
}"""

val RUBY_RELEASE_RECORD = """{
  "language" : "RUBY",
  "supportedVersion" : "2.7",
  "latestVersion" : "2.7.2",
  "latestReleaseNote" : "www.ruby-lang.org/en/news/2020/10/02/ruby-2-7-2-released/"
}"""

val SWIFT_RELEASE_RECORD = """{
  "language" : "SWIFT",
  "supportedVersion" : "5.3",
  "latestVersion" : "5.3.1",
  "latestReleaseNote" : "https://github.com/apple/swift/releases/tag/swift-5.3.1-RELEASE"
}"""

val DOTTY_RELEASE_RECORD = """{
  "language" : "DOTTY",
  "supportedVersion" : "0.26.0",
  "latestVersion" : "0.26.0",
  "latestReleaseNote" : "https://github.com/lampepfl/dotty/releases/tag/0.26.0"
}"""
