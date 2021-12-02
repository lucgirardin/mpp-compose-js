plugins {
    kotlin("multiplatform") apply false
    id("com.github.ben-manes.versions")
}

group = "com.macrofocus"
version = "1.0"

allprojects {
    repositories {
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }

    configurations.all {
        resolutionStrategy {
            dependencySubstitution {
                substitute(
                    module("com.macrofocus:common")
                ).using(project(":common")).because("we work with the unreleased development version")
            }
        }
    }
}

