plugins {
    java
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    application
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
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":scrapper"))
    implementation("com.google.code.gson:gson:2.8.6")

    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("org.margo.languagesradar.function.ReleasesFunctionKt")
    mainClassName = "org.margo.languagesradar.function.ReleasesFunctionKt"
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

tasks.named("build") {
    dependsOn(":function:shadowJar")
}

task("buildFunction") {
    dependsOn("build")
    copy {
        from("build/libs/function-1.0-SNAPSHOT-all.jar")
        into("build/deploy")
    }
}
