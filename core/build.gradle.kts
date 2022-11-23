import dependencies.appDep

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
//    id("dagger.hilt.android.plugin")
}

apply{
    from("../shared_dependencies.kts")
}

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
//        compose = true
    }
//
//    composeOptions {
//        kotlinCompilerExtensionVersion = Versions.composeVersion
//        kotlinCompilerVersion = Versions.kotlinVersion
//    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.2")
    implementation(appDep.constraint)
    implementation(appDep.navigationFragmentKtx)
    implementation(appDep.navigationUiKtx)
    implementation(appDep.activityKtx)

    //Retrofit
//    implementation ("com.google.code.gson:gson:2.8.9")
//    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
//
//    //Ok Http
//    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
//    implementation ("com.squareup.okhttp3:okhttp:4.9.2")

//    // Retrofit
//    implementation(Dependencies.RetrofitDep.loggingInterceptor)
//    implementation(Dependencies.RetrofitDep.moshiConverter)
//    implementation(Dependencies.RetrofitDep.retrofit)

    // Coroutines
//    appDep.Coroutines.forEach {
//        implementation(it)
//    }
    // Glide
    implementation(appDep.glide)
    kapt(appDep.glideKapt)
    // Timber
    implementation(appDep.timber)
    // Lottie animation
    implementation(appDep.lottie)

    // Test Dependencies
    testImplementation(appDep.Test.junit)
    testImplementation(appDep.Test.assertJ)
    testImplementation(appDep.Test.mockitoKotlin)
    testImplementation(appDep.Test.mockitoInline)
    testImplementation(appDep.Test.coroutines)
    testImplementation(appDep.Test.androidxArchCore)
    testImplementation(appDep.Test.robolectric)
    testImplementation(appDep.Test.testExtJunit)
}

kapt {
    correctErrorTypes = true
}