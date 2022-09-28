import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}
group = "me.gbrown"
version = "1.0-SNAPSHOT"
val kotlinVersion = "1.7.10"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.4.2")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "17"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "17"
}
