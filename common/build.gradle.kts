import org.jetbrains.compose.compose

val applyComposePlugin = true // Problem appear irrespectively of how the compose plugin is enabled
plugins {
    val applyComposePlugin = true // Same as above: val applyComposePlugin: Boolean' can't be called in this context by implicit receiver.
    kotlin("multiplatform") version "1.4.32"
    id("org.jetbrains.compose") version "0.0.0-web-dev-11" apply applyComposePlugin
}

group = "com.macrofocus"
version = "1.0"

repositories {
    google()
}

kotlin {
    jvm("desktop") {
        if (!applyComposePlugin) {
            apply<org.jetbrains.compose.ComposePlugin>()
        }
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    // Bug: work with LEGACY, not with IR (or both)
    js("web", IR) {
        browser()
        compilations.all {
            // This does not help!
            kotlinOptions.freeCompilerArgs += arrayOf(
                "-Xskip-prerelease-check",
                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
            )
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting
        val webMain by getting {
            dependencies {
                implementation(compose.web.web)
                implementation(compose.runtime)
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
