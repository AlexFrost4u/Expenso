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

        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCompiler
    }
}

dependencies {
    api(Dependency.AndroidX.appcompat)
    api(Dependency.AndroidX.Compose.ui)
    api(Dependency.AndroidX.Compose.tooling)
    api(Dependency.AndroidX.Compose.toolingPreview)
    api(Dependency.AndroidX.Compose.runtime)
    api(Dependency.AndroidX.Compose.foundation)
    api(Dependency.AndroidX.Compose.material)

    implementation(Dependency.Loggers.prettyLogger)
}
