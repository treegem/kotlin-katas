import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
}
group = "me.gbrown"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.2.0")
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}