plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    buildFeatures {
        buildConfig = false

        aidl = false
        prefab = false
        shaders = false

        compose = false
    }
}

dependencies {
    api(Dependency.Kotlin.stdlib)
}
