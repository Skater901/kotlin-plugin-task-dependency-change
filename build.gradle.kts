plugins {
    kotlin("jvm") version "2.0.10-RC"
}

group = "au.com.skater901"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    test {
        useJUnitPlatform()
    }

    register("example") {
        dependsOn(testClasses)

        println("I ran after the test compilation but before the jar was built!")
    }

    jar {
        dependsOn("example")
    }
}

kotlin {
    jvmToolchain(21)
}