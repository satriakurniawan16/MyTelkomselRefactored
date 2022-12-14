package dependencies

import Versions

object Dependencies {

    object KotlinDep {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    }

    object JavaDep {
        const val javax = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    }

    object ComponentDep {
        const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"

        // Material design icons
        const val materialIcon =
            "androidx.compose.material:material-icons-core:${Versions.composeVersion}"

        // Tooling support (Preview)
        const val composeUiToolPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"

        // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
        const val composeFondation =
            "androidx.compose.foundation:foundation:${Versions.composeVersion}"

        // Material Design
        const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
        const val materialIconExtension =
            "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"
        const val composeActivty = "androidx.activity:activity-compose:1.3.1"

        // UI Tests
        const val composeUiTest = "androidx.compose.ui:ui-test-junit:${Versions.composeVersion}"
    }

    object CoreDep {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val constraint =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val navigationFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navFragmentKtxVersion}"
        const val navigationUiKtx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navUiKtxVersion}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtxVersion}"
    }

    object LifeCycleDep {
        const val viewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelKtxVersion}"
        const val liveDataKtx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveDataKtxVersion}"
        const val lifeCycleExtension =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycleExtVersion}"
        const val lifeCycleRuntime =
            "androidx.lifecycle:lifecycle-runtime:${Versions.lifeCycleRuntimeVersion}"
        const val lifeCycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleRuntimeKtxVersion}"
    }

    object DaggerHiltCoreDep {
        const val hiltCore = "com.google.dagger:dagger:2.42"
        const val hiltCoreKapt = "com.google.dagger:dagger-compiler:2.38.1"
    }

    object DaggerAndroidDep {
        const val daggerAndroid = "com.google.dagger:dagger-android:2.37"
        const val daggerAndroidKapt = "com.google.dagger:dagger-android-processor:2.37"
        const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:2.37"
    }

    object DaggerHiltDep {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroidVersion}"
        const val hiltCompilerKapt = "com.google.dagger:hilt-compiler:${Versions.hiltAndroidVersion}"
        const val hiltAndroidKapt = "com.google.dagger:hilt-android-compiler:2.37"
        const val hiltKapt = "androidx.hilt:hilt-compiler:${Versions.hiltVersion}"
    }

    object CoroutinesDep {
        const val coroutineCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineCoreVersion}"
        const val coroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroidVersion}"
    }

    object GlideDep {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
        const val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    }

    object TimberDep {
        const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    }


    object RetrofitDep {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
        const val scalarsConverterConverter = "com.squareup.retrofit2:converter-scalars:${Versions.scalarsConverterVersion}"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverterVersion}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    }

    

    object RoomDep {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomCompilerKapt = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    }

    object LottieDep {
        const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
    }

    object TestDep {
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTestVersion}"
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val assertJ = "org.assertj:assertj-core:${Versions.assertJVersion}"
        const val mockitoKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
        const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
        const val testRunner = "androidx.test:runner:${Versions.androidTestRunnerVersion}"
        const val testRules = "androidx.test:rules:${Versions.androidTestRuleVersion}"
        const val testCore = "androidx.test:core:${Versions.axTestCore}"
        const val testExtJunit = "androidx.test.ext:junit:${Versions.axTestJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val espressoIntents =
            "androidx.test.espresso:espresso-intents:${Versions.espressoVersion}"
        const val espressoContrib =
            "androidx.test.espresso:espresso-contrib:${Versions.espressoVersion}"
        const val androidxArchCore =
            "androidx.arch.core:core-testing:${Versions.androidxArchCoreVersion}"
        const val androidxTestExtJunit = "androidx.test.ext:${Versions.extJunitVersion}"
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
        const val roomTest = "androidx.room:room-testing:${Versions.roomVersion}"
    }

}
