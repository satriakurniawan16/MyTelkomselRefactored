import dependencies.appDep
import dependencies.Dependencies
import kotlin.io.*
import java.util.*
import java.io.FileInputStream

plugins {
    id(Config.Plugins.androidApplication)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.daggerHiltPlugins)
    id(Config.Plugins.kotlinParcelize)
}

val version = Environments.Release.appVersionName
val buildVersion = version

//apply {
//    from("../shared_dependencies.kts")
//}

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

        testInstrumentationRunner = Config.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }

        resConfigs("en", "in")

        getProps("./config/allvariant.props").onEach { p ->
            if (p.key.toString().contains("buildConfig")) {
                buildConfigField(
                    "String",
                    p.key.toString().replace("buildConfig.", ""),
                    p.value.toString()
                )
            } else if (p.key.toString().contains("resValue")) {
                resValue("string", p.key.toString().replace("resValue.", ""), p.value.toString())
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
            buildConfigField("String", "HEADER_ORIGIN_VALUE", "\"file://\"")
            buildConfigField("String", "HEADER_CHANNELID_VALUE", "\"UX\"")
            buildConfigField("boolean", "ENABLE_CRASHLYTICS", "true")
            buildConfigField("String", "HEADER_X_REQUESTED_VALUE", "\"com.telkomsel.mytelkomsel\"")
            buildConfigField("String", "APP_VERSION", "\"$version\"")
            resValue("string", "appVersion", buildVersion)
        }
        getByName("debug") {
            buildConfigField("String", "HEADER_ORIGIN_VALUE", "\"file://\"")
            buildConfigField("String", "HEADER_CHANNELID_VALUE", "\"UX\"")
            buildConfigField("boolean", "ENABLE_CRASHLYTICS", "true")
            buildConfigField("String", "HEADER_X_REQUESTED_VALUE", "\"com.telkomsel.mytelkomsel\"")
            buildConfigField("String", "APP_VERSION", "\"$version\"")
            resValue("string", "appVersion", "$buildVersion-DEBUG")
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
    implementation(Dependencies.KotlinDep.kotlin)
    implementation(Dependencies.CoreDep.coreKtx)

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

    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation(Dependencies.DaggerHiltDep.hiltAndroid)
    kapt(Dependencies.DaggerHiltDep.hiltCompilerKapt)
    kapt(Dependencies.DaggerHiltDep.hiltKapt)

    // Coroutines-----------
    implementation(Dependencies.CoroutinesDep.coroutineCore)
    implementation(Dependencies.CoroutinesDep.coroutineAndroid)


    //Retrofit
    appDep.retrofit.forEach {
        implementation(it)
    }

    //Ok Http
    appDep.okhttp.forEach {
        implementation(it)
    }

    //Chuck
    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")


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
}
