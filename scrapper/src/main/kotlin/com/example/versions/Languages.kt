package com.example.versions

object Languages {
    
    val RELEASES_URL: Map<Project, String> = mapOf(
        Project.JAVA to "https://www.oracle.com/java/technologies/javase/jdk-relnotes-index.html",
        Project.KOTLIN to "https://kotlinlang.org/releases.html",
        Project.SCALA to "https://github.com/scala/scala/releases",
        Project.GO to "https://golang.org/doc/devel/release.html",
        Project.RUBY to "https://www.ruby-lang.org/en/downloads/releases/",
        Project.APEX to "https://developer.salesforce.com/docs/atlas.en-us.apexcode.meta/apexcode/apex_intro_what_is_apex.htm",
        Project.SWIFT to "https://swift.org/download/#releases",
        Project.DOTTY to "https://github.com/lampepfl/dotty/releases",
        Project.SCALA_META to "https://github.com/scalameta/scalameta/releases/tag/v4.4.10"
    )
    
    val SUPPORTED_VERSIONS: Map<Project, String> = mapOf(
        Project.JAVA to "14",
        Project.KOTLIN to "1.4",
        Project.SCALA to "2.13",
        Project.GO to "1.15",
        Project.RUBY to "2.7",
        Project.APEX to "50",
        Project.SWIFT to "5.3",
        Project.DOTTY to "0.26.0",
        Project.SCALA_META to "4.3.24"
    )

    val LATEST_KNOWN_VERSIONS: Map<Project, String> = mapOf(
        Project.JAVA to "15",
        Project.KOTLIN to "1.4.31",
        Project.SCALA to "2.13.5",
        Project.GO to "1.16",
        Project.RUBY to "3.0.0",
        Project.APEX to "50",
        Project.SWIFT to "5.3.3",
        Project.DOTTY to "0.26.0",
        Project.SCALA_META to "4.4.10"
    )
    
}

enum class Project {
    JAVA,
    KOTLIN,
    SCALA,
    GO,
    RUBY,
    APEX,
    SWIFT,
    DOTTY,
    SCALA_META
}
