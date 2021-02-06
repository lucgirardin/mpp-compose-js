import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform") version "1.4.20"
    id("org.jetbrains.compose") version "0.2.0-build132"
}

group = "com.macrofocus"
version = "1.0"

repositories {
    google()
}

kotlin {
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
            }
        }
        val commonTest by getting
        val desktopMain by getting
        val desktopTest by getting
    }
}
