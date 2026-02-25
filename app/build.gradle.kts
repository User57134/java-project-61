plugins {
    id("com.github.ben-manes.versions") version "0.53.0"
    id("org.sonarqube") version "7.1.0.6387"
    application
    checkstyle
}

sonar {
    properties {
        property("sonar.projectKey", "User57134_java-project-61")
        property("sonar.organization", "user57134")
    }
}


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}


group = "hexlet.code"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}


application {
    mainClass.set("hexlet.code.App")
}


tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}