plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.osipov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val lombokVersion = property("lombok.version") as String
val kotlinVersion = property("kotlin.version") as String
val coroutineVersion = property("coroutine.version") as String

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")

    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}