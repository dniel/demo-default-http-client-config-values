import io.micronaut.gradle.MicronautRuntime

plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("kapt") version "1.9.23"
    id("io.micronaut.application") version "4.5.4"
}

version = "0.1"
group = "com.example"

val micronautVersion: String by project
val jvmVersion = "21" // 17 does not work, 19+ works

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("io.micronaut.openapi:micronaut-openapi-annotations")

    // Parsing av yml
    runtimeOnly("org.yaml:snakeyaml")
}

// This causes it not to work
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(jvmVersion))
    }
}

application {
    mainClass = "com.example.ApplicationKt"
}

graalvmNative.toolchainDetection = false

micronaut {
    version(micronautVersion)
    runtime(MicronautRuntime.LAMBDA_JAVA)
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}
