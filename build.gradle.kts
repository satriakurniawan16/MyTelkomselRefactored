// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        mavenCentral()
        maven(url = Config.ClassPaths.pluginGradle)
        maven (url = "https://jitpack.io")
    }

    dependencies {
//        classpath(Config.ClassPaths.androidGradle)
//        classpath(Config.ClassPaths.kotlinGradle)
//        classpath(Config.ClassPaths.daggerHiltGradle)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
//        // KtLint
//        classpath(Config.ClassPaths.ktLint)
    }
}

//apply(from = "gradle/jacoco.gradle")

allprojects {
//    apply(plugin = Config.ClassPaths.pluginKtLint) // Version should be inherited from parent
    repositories {
        mavenCentral()
        google()
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = Config.ClassPaths.googleUrl)
        maven(url = Config.ClassPaths.jitPackUrl)
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
