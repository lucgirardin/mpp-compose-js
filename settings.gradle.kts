pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }

    plugins {
        kotlin("multiplatform") version "1.5.31" apply false
        id("org.jetbrains.compose") version "1.0.0" apply false
        id("com.github.ben-manes.versions") version "0.39.0" apply false
    }
}
rootProject.name = "mpp-compose-js"

include(":desktop")
include(":common")

