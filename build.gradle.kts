// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        mavenCentral()
        maven(url = Config.ClassPaths.pluginGradle)
        maven (url = Config.ClassPaths.pluginGradle)
    }

    dependencies {
        classpath(Config.ClassPaths.androidGradle)
        classpath(Config.ClassPaths.kotlinGradle)
        classpath(Config.ClassPaths.daggerHiltGradle)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
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
        maven(url = Config.ClassPaths.pluginGradle)
        maven(url = Config.ClassPaths.googleUrl)
        maven(url = Config.ClassPaths.jitPackUrl)
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
