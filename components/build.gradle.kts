import dependencies.appDep
import dependencies.componentDep
import Versions

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

apply{
//    from("../shared_dependencies.kts")
}

android {
    compileSdkVersion(Config.Android.androidCompileSdkVersion)
    buildToolsVersion(Config.Android.androidBuildToolsVersion)

    defaultConfig {
        minSdkVersion(Config.Android.androidMinSdkVersion)
        targetSdkVersion(Config.Android.androidTargetSdkVersion)
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


//    composeOptions {
//        kotlinCompilerExtensionVersion = Versions.composeVersion
//        kotlinCompilerVersion = Versions.kotlinVersion
//    }
}

dependencies {

//    implementation(appDep.coreKtx)
    implementation(appDep.appCompat)
    implementation(appDep.material)

//    testImplementation(componentDep.testCompose)

    testImplementation(appDep.Test.junit)
    testImplementation(appDep.Test.assertJ)
    testImplementation(appDep.Test.mockitoKotlin)
    testImplementation(appDep.Test.mockitoInline)
    testImplementation(appDep.Test.coroutines)
    testImplementation(appDep.Test.androidxArchCore)
//    testImplementation(appDep.Test.robolectric)
    testImplementation(appDep.Test.testExtJunit)
}

kapt {
    correctErrorTypes = true
}