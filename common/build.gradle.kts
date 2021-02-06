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
    // Bug: work with LEGACY, not with IR
    js("web", LEGACY) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting
        val webMain by getting {
            dependencies {
            }
        }
        val webTest by getting
        val desktopMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
            }
        }
        val desktopTest by getting
    }
}
