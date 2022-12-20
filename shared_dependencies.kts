import dependencies.Dependencies
import dependencies.appDep
import dependencies.componentDep


dependencies{
    // Core Dependencies
    implementation(Dependencies.KotlinDep.kotlin)
    implementation(Dependencies.CoreDep.coreKtx)

    implementation(Dependencies.CoroutinesDep.coroutineCore)
    implementation(Dependencies.CoroutinesDep.coroutineAndroid)
}