plugins {
    java
    kotlin("jvm") version "1.4.10"
    jacoco
    application
}

group = "com.example.versions"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

jacoco {
    toolVersion = "0.8.6"
    reportsDir = file("$buildDir/reports/jacoco")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-core:1.4.0")
    implementation("io.ktor:ktor-server-netty:1.4.0")
    implementation("io.ktor:ktor-jackson:1.4.0")
    implementation("io.ktor:ktor-html-builder:1.4.3")

    implementation(project(":scrapper"))
    implementation(project(":html-extender"))
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.willowtreeapps.assertk:assertk:0.23")
    testImplementation("io.ktor:ktor-server-test-host:1.4.3")
}

application {
    mainClass.set("com.example.versions.server.ServerKt")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.isEnabled = true
        csv.isEnabled = false
        html.destination = file("${buildDir}/jacocoHtml")
    }
}
