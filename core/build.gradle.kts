import dependencies.appDep
import dependencies.Dependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

//apply{
//    from("../shared_dependencies.kts")
//}

android {
    compileSdkVersion(Config.Android.androidCompileSdkVersion)
    buildToolsVersion(Config.Android.androidBuildToolsVersion)

    defaultConfig {
        minSdkVersion(Config.Android.androidMinSdkVersion)
        targetSdkVersion(Config.Android.androidTargetSdkVersion)

        testInstrumentationRunner = Config.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }

        // Configs
//        buildConfigField("String", "BASE_URL", "\"" + Environments.Release.baseUrl + "\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(appDep.appCompat)

    // Core Dependencies
    implementation(Dependencies.KotlinDep.kotlin)
    implementation(Dependencies.CoreDep.coreKtx)

    // LifeCycle
    appDep.LifeCycle.forEach {
        implementation(it)
    }

    //Coroutine
    implementation(Dependencies.CoroutinesDep.coroutineCore)
    implementation(Dependencies.CoroutinesDep.coroutineAndroid)

    //Dagger
    
    implementation(Dependencies.DaggerHiltDep.hiltAndroid)
    kapt(Dependencies.DaggerHiltDep.hiltCompilerKapt)
    kapt(Dependencies.DaggerHiltDep.hiltKapt)



}

kapt {
    correctErrorTypes = true
}