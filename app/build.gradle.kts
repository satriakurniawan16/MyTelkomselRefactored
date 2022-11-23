import dependencies.appDep
import kotlin.io.*
import java.util.*
import java.io.FileInputStream

plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}

val version = Environments.Release.appVersionName
val buildVersion = version

apply{
    from("../shared_dependencies.kts")
}

android {
    compileSdk = 33
    buildToolsVersion = Config.Android.androidBuildToolsVersion


    fun getProps(path: String): Properties {
        val props = Properties()
        props.load(FileInputStream(file(path)))
        return props
    }

    defaultConfig {
        applicationId = Environments.Release.appId
        minSdk = 21
        targetSdk = 33
        versionCode = Environments.Release.appVersionCode
        versionName = Environments.Release.appVersionName

        testInstrumentationRunner =Config.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }

        resConfigs("en", "in")

        getProps("./config/allvariant.props").onEach { p ->
            if (p.key.toString().contains("buildConfig")) {
                println("kontol buildConfig ${p.value.toString()}")
                buildConfigField(
                    "String",
                    p.key.toString().replace("buildConfig.", ""),
                    p.value.toString()
                )
            } else if (p.key.toString().contains("resValue")) {
                resValue("string", p.key.toString().replace("resValue.", ""), p.value.toString())
                println("kontol buildConfig ${p.value.toString()}")
            }
        }

        // Configs
//        buildConfigField("String", "BASE_URL", "\"" + Environments.Release.baseUrl + "\"")
    }


    flavorDimensions += "pack"

    productFlavors {
        create("developement") {
            applicationId = "com.telkomsel.mytelkomsel"
            applicationIdSuffix = ".developement"
            dimension = "pack"
            println("generating configuration from config dev properties")
            manifestPlaceholders["hostName"] = "tdwidm.telkomsel.com"
            manifestPlaceholders["auth0Scheme"] = "mytelkomselpreprod"
            manifestPlaceholders["partner"] = "mytelkomselpreprod"

            getProps("./config/dev.props").onEach { p ->
                if (p.key.toString().contains("buildConfig")) {
                    println("kontol buildConfig ${p.value.toString()}")
                    buildConfigField(
                        "String",
                        p.key.toString().replace("buildConfig.", ""),
                        p.value.toString()
                    )
                } else if (p.key.toString().contains("resValue")) {
                    resValue(
                        "string",
                        p.key.toString().replace("resValue.", ""),
                        p.value.toString()
                    )
                    println("kontol buildConfig ${p.value.toString()}")
                }
            }
        }
        create("preproduction") {
            applicationId = "com.telkomsel.mytelkomsel"
            applicationIdSuffix = ".preproduction"
            dimension = "pack"
            println("generating configuration from config preproduction properties")
            manifestPlaceholders["hostName"] = "tdwidm.telkomsel.com"
            manifestPlaceholders["auth0Scheme"] = "mytelkomselpreprod"
            manifestPlaceholders["partner"] = "mytelkomselpreprod"

            getProps("./config/preprod.props").onEach { p ->
                if (p.key.toString().startsWith("buildConfig")) {
                    println("kontol buildConfig ${p.value.toString()}")
                    buildConfigField(
                        "String",
                        p.key.toString().replace("buildConfig.", ""),
                        p.value.toString()
                    )
                } else if (p.key.toString().startsWith("resValue")) {
                    resValue(
                        "string",
                        p.key.toString().replace("resValue.", ""),
                        p.value.toString()
                    )
                    println("kontol buildConfig ${p.value.toString()}")
                }
            }
        }
        create("production") {
            applicationId = "com.telkomsel.telkomselcm"
            applicationIdSuffix = ".production"
            dimension = "pack"
            println("generating configuration from config production properties")
            manifestPlaceholders["hostName"] = "tdwidm.telkomsel.com"
            manifestPlaceholders["auth0Scheme"] = "mytelkomsel"
            manifestPlaceholders["partner"] = "mytelkomselprod"

            getProps("./config/prod.props").onEach { p ->
                if (p.key.toString().contains("buildConfig")) {
                    println("kontol buildConfig ${p.value.toString()}")
                    buildConfigField(
                        "String",
                        p.key.toString().replace("buildConfig.", ""),
                        p.value.toString()
                    )
                } else if (p.key.toString().contains("resValue")) {
                    resValue(
                        "string",
                        p.key.toString().replace("resValue.", ""),
                        p.value.toString()
                    )
                }
            }
        }
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField ("String", "HEADER_ORIGIN_VALUE", "\"file://\"")
            buildConfigField ("String", "HEADER_CHANNELID_VALUE", "\"UX\"")
            buildConfigField ("boolean", "ENABLE_CRASHLYTICS", "true")
            buildConfigField ("String", "HEADER_X_REQUESTED_VALUE", "\"com.telkomsel.mytelkomsel\"")
            buildConfigField ("String", "APP_VERSION", "\"$version\"")
            resValue ("string", "appVersion", buildVersion)
        }
        getByName("debug") {
            buildConfigField("String", "HEADER_ORIGIN_VALUE", "\"file://\"")
            buildConfigField("String", "HEADER_CHANNELID_VALUE", "\"UX\"")
            buildConfigField ("boolean", "ENABLE_CRASHLYTICS", "true")
            buildConfigField ("String", "HEADER_X_REQUESTED_VALUE", "\"com.telkomsel.mytelkomsel\"")
            buildConfigField ("String", "APP_VERSION", "\"$version\"")
            resValue ("string", "appVersion", "$buildVersion-DEBUG")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

kapt {
    correctErrorTypes = true
    generateStubs = true
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //module
    implementation(project(":components"))
    implementation(project(":core"))

    // Core Dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")
    implementation("androidx.core:core-ktx:1.9.0")

    implementation(appDep.appCompat)
    implementation(appDep.material)
    implementation(appDep.constraint)
    implementation(appDep.navigationFragmentKtx)
    implementation(appDep.navigationUiKtx)
    implementation(appDep.activityKtx)

    // LifeCycle
    appDep.LifeCycle.forEach {
        implementation(it)
    }

//    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

//    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroidVersion}"
//    const val hiltAndroidKapt = "com.google.dagger:hilt-compiler:${Versions.hiltAndroidVersion}"
//    const val hiltKapt = "androidx.hilt:hilt-compiler:${Versions.hiltVersion}"

    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-compiler:2.42")
    kapt("androidx.hilt:hilt-compiler:1.0.0")



//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.1")

    // When using a AppCompat theme
//    implementation("com.google.accompanist:accompanist-appcompat-theme:0.25.1")

    implementation("com.squareup.retrofit2:converter-moshi:2.7.0")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

//    const val coroutineAndroid =
//        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroidVersion}"
//    appDep.Coroutines.forEach {
//        implementation(it)
//    }
    // Glide
    implementation(appDep.glide)
    kapt(appDep.glideKapt)

    // Timber
    implementation(appDep.timber)

    // Test Dependencies
    testImplementation(appDep.Test.junit)
    testImplementation(appDep.Test.assertJ)
    testImplementation(appDep.Test.mockitoKotlin)
    testImplementation(appDep.Test.mockitoInline)
//    testImplementation(appDep.Test.coroutines)
    testImplementation(appDep.Test.androidxArchCore)
//    testImplementation(appDep.Test.robolectric)
    testImplementation(appDep.Test.testExtJunit)


    //Retrofit
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")

    //Ok Http
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.2")

    //Chuck
    debugImplementation ("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation ("com.github.chuckerteam.chucker:library-no-op:3.5.2")

    //Coroutines
//    preproductionImplementation ("com.github.chuckerteam.chucker:library:3.5.2")
//    productionReleaseImplementation ("com.github.chuckerteam.chucker:library-no-op:3.5.2")

}
