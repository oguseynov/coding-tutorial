import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.support.ReporterType

group = "com.oguseynov.testingschool"

repositories {
    mavenCentral()
    jcenter()
}

plugins {
    kotlin("jvm") version "1.3.70"
    id("org.jmailen.kotlinter") version "2.3.2"
}

group = "kz.btsd"

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

    withType<Test> {
        useJUnitPlatform()

        systemProperty("kotlintest.tags.include", System.getProperty("kotlintest.tags.include"))
        systemProperty("kotlintest.tags.exclude", System.getProperty("kotlintest.tags.exclude"))

        testLogging {
            showStandardStreams = true
            showStackTraces = true
            exceptionFormat = FULL
            events = mutableSetOf(PASSED, FAILED, SKIPPED, STANDARD_OUT, STANDARD_ERROR)
        }

        dependsOn("cleanTest")
    }
}

dependencies {
    val kotestVersion = "4.0.1"
    val javafakerVersion = "1.0.2"
    val slf4jSimpleVersion = "1.7.25"
    val fuelVersion = "2.2.1"

    implementation(kotlin("stdlib-jdk8"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("com.github.javafaker:javafaker:$javafakerVersion")
    testImplementation("org.slf4j:slf4j-simple:$slf4jSimpleVersion")
    testImplementation("com.github.kittinunf.fuel:fuel:$fuelVersion")
    testImplementation("com.github.kittinunf.fuel:fuel-moshi:$fuelVersion")
}

kotlinter {
    ignoreFailures = false
    indentSize = 4
    reporters = arrayOf(ReporterType.checkstyle.name, ReporterType.plain.name, ReporterType.html.name)
}
