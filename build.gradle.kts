import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.jvm.tasks.Jar
import org.gradle.api.tasks.testing.Test

plugins {
    kotlin("jvm") version "2.3.21"
}

group = "com.turashift.kotlincmd"
version = "13-17082026a"

sourceSets {
    main {
        kotlin.srcDirs("src/main/kotlin")
        java.srcDirs("src/main/kotlin")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(
            "Main-Class" to "com.turashift.kotlincmd.MainKt"
        )
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from ({
        configurations.named("runtimeClasspath").get().filter { it.exists() }.map { if (it.isDirectory) it else zipTree(it) }
    })
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 21
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
