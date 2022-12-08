package dependencies

object appDep {
    // Kotlin
    const val kotlin = Dependencies.KotlinDep.kotlin

    // Core
    const val coreKtx = Dependencies.CoreDep.coreKtx
    const val appCompat = Dependencies.CoreDep.appCompat
    const val material = Dependencies.CoreDep.material
    const val constraint = Dependencies.CoreDep.constraint
    const val navigationFragmentKtx = Dependencies.CoreDep.navigationFragmentKtx
    const val navigationUiKtx = Dependencies.CoreDep.navigationUiKtx
    const val activityKtx = Dependencies.CoreDep.activityKtx

    // LifeCycle
    val LifeCycle = listOf(
        Dependencies.LifeCycleDep.viewModelKtx,
        Dependencies.LifeCycleDep.lifeCycleExtension,
        Dependencies.LifeCycleDep.lifeCycleRuntime,
        Dependencies.LifeCycleDep.lifeCycleRuntimeKtx
    )

    // Hilt
    val DaggerHilt = listOf(
        Dependencies.DaggerHiltCoreDep.hiltCore,
        Dependencies.DaggerHiltDep.hiltAndroid
    )

    val retrofit = listOf(
        Dependencies.RetrofitDep.gson,
        Dependencies.RetrofitDep.gsonConverter,
        Dependencies.RetrofitDep.retrofit,
        Dependencies.RetrofitDep.moshiConverter,
    )

    val okhttp = listOf(
        Dependencies.RetrofitDep.loggingInterceptor,
        Dependencies.RetrofitDep.scalarsConverterConverter
    )

    //Hilt Api
    val DaggerHiltApi = listOf(
        Dependencies.DaggerAndroidDep.daggerAndroid,
        Dependencies.DaggerAndroidDep.daggerAndroidSupport
    )

    // Hilt Kapt
    val DaggerHiltKapt = listOf(
        Dependencies.DaggerHiltCoreDep.hiltCoreKapt,
        Dependencies.DaggerAndroidDep.daggerAndroidKapt,
        Dependencies.DaggerHiltDep.hiltAndroidKapt
    )

    // Coroutines
    val Coroutines = listOf(
        Dependencies.CoroutinesDep.coroutineCore,
        Dependencies.CoroutinesDep.coroutineAndroid
    )

    const val glide = Dependencies.GlideDep.glide
    const val glideKapt = Dependencies.GlideDep.glideKapt
    const val timber = Dependencies.TimberDep.timber
    const val lottie = Dependencies.LottieDep.lottie

    object Test {
        const val junit = Dependencies.TestDep.junit
        const val coroutines = Dependencies.TestDep.coroutinesTest
        const val mockitoKotlin = Dependencies.TestDep.mockitoKotlin
        const val mockitoInline = Dependencies.TestDep.mockitoInline
        const val assertJ = Dependencies.TestDep.assertJ
        const val androidxArchCore = Dependencies.TestDep.androidxArchCore
        const val robolectric = Dependencies.TestDep.robolectric
        const val testExtJunit = Dependencies.TestDep.testExtJunit
    }
}