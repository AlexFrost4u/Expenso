object AndroidConfig {
    const val compileSdk = 32
    const val minSdk = 26
    const val targetSdk = 32
    const val buildTools = "32.0.0"

    const val versionCode = 1
    const val versionName = "0.0.1"

    const val applicationId = "com.alexfrost.expenso"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val isDebuggable: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val isDebuggable = true
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
    override val isDebuggable = false
}
