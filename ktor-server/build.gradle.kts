plugins {
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.0")
    implementation("io.ktor:ktor-server-core:1.5.4")
    implementation("io.ktor:ktor-server-netty:1.5.4")
    implementation("io.ktor:ktor-jackson:1.5.4")
    implementation("io.ktor:ktor-html-builder:1.5.4")

    implementation(project(":scrapper"))
    implementation(project(":html-extender"))
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.willowtreeapps.assertk:assertk:0.23")
    testImplementation("io.ktor:ktor-server-test-host:1.5.4")
}

application {
    mainClass.set("com.example.versions.server.ServerKt")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
