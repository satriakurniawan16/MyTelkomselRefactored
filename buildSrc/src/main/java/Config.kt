object Config {

    object Android {
        // Android sdk and version
        const val androidMinSdkVersion = 21
        const val androidTargetSdkVersion = 32
        const val androidCompileSdkVersion = 32
        const val androidBuildToolsVersion = "30.0.2"
    }

    object ClassPaths {
        const val androidGradle = "com.android.tools.build:gradle:4.2.1"
        const val kotlinGradle =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20"
        const val daggerHiltGradle =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroidVersion}"
        const val navigationSafArgsGradle =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.gradleNavigationArgVersion}"
        const val ktLint ="org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLintVersion}"

        const val jitPackUrl = "https://jitpack.io"
        const val googleUrl = "https://maven.google.com/"
        const val pluginGradle = "https://plugins.gradle.org/m2/"
        const val pluginKtLint = "org.jlleitschuh.gradle.ktlint"
    }

    object Plugins {

        const val androidApplication = "com.android.application"
        const val kotlinJetbrains = "org.jetbrains.kotlin.android"
        const val android = "android"
        const val kotlinExtensions = "kotlin-android-extensions"
        const val kotlin = "kotlin"
        const val javaLibrary = "java-library"
        const val kotlinAndroid = "kotlin-android"
        const val navigationSafArgs = "androidx.navigation.safeargs.kotlin"
        const val kotlinKapt = "kotlin-kapt"
        const val androidLibrary = "com.android.library"
    }

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}