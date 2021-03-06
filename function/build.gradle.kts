plugins {
    id("com.github.johnrengelman.shadow")
    application
}

repositories {
    jcenter()
}

val invoker by configurations.creating

dependencies {
    compileOnly("com.google.cloud.functions:functions-framework-api:1.0.1")
    invoker("com.google.cloud.functions.invoker:java-function-invoker:1.0.0-alpha-2-rc5")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":scrapper"))
    implementation(project(":html-extender"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    implementation("com.google.code.gson:gson:2.8.6")

    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("com.example.versions.function.ReleasesFunctionKt")
    mainClassName = "com.example.versions.function.ReleasesFunctionKt" // used by gc function
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
