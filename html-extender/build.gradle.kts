repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":scrapper"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
}
