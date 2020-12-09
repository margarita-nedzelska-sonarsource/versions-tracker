plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "com.example.versions"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":scrapper"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
}
