plugins {
    id("com.github.ben-manes.versions") version "0.36.0"
}

group = "com.macrofocus"
version = "1.0"

allprojects {
    repositories {
        jcenter()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}