buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url ="https://www.jitpack.io" )
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false
}