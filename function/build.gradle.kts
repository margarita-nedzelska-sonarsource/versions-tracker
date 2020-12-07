buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
    }
}

plugins {
    java
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "5.2.0"
    
}

group = "com.margo.versionsradar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val invoker by configurations.creating

dependencies {
    compileOnly("com.google.cloud.functions:functions-framework-api:1.0.1")
    invoker("com.google.cloud.functions.invoker:java-function-invoker:1.0.0-alpha-2-rc5")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.register<JavaExec>("runFunction") {

    main = "com.google.cloud.functions.invoker.runner.Invoker"
    classpath(invoker)
    inputs.files(configurations.runtimeClasspath, sourceSets["main"].output)
    args(
        "--target", project.findProperty("runFunction.target") ?: "",
        "--port", project.findProperty("runFunction.port") ?: 8080
    )
    doFirst {
        args("--classpath", files(configurations.runtimeClasspath, sourceSets["main"].output).asPath)
    }
}
