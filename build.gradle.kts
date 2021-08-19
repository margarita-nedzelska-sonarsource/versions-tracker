plugins {
    jacoco
    kotlin("jvm") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("org.sonarqube") version "3.3"
}

allprojects {
    group = "com.example.versions"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "jacoco")

    jacoco {
        toolVersion = "0.8.7"
    }

    val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
    compileKotlin.kotlinOptions.useIR = true
}

sonarqube {
    properties {
        property("sonar.projectKey", "margarita-nedzelska-sonarsource_LanguagesVersionsRadar")
        property("sonar.organization", "margarita-nedzelska")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
