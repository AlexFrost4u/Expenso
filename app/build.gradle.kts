plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
    id(Plugins.kapt)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isDebuggable = BuildTypeRelease.isDebuggable
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isDebuggable = BuildTypeDebug.isMinifyEnabled
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCompiler
    }

    buildFeatures {
        buildConfig = false

        aidl = false
        prefab = false
        shaders = false

        compose = true
    }
}

dependencies {
    // Function modules
    implementation(project(ModuleDependency.Core.common))
    implementation(project(ModuleDependency.Core.ui))

    // Libraries
    implementation(Dependency.AndroidX.core)
    implementation(Dependency.AndroidX.appcompat)
    implementation(Dependency.AndroidX.material)
    implementation(Dependency.AndroidX.navigationCompose)
    implementation(Dependency.AndroidX.activityCompose)
    implementation(Dependency.AndroidX.splashScreen)

    implementation(Dependency.AndroidX.Compose.ui)
    implementation(Dependency.AndroidX.Compose.tooling)
    implementation(Dependency.AndroidX.Compose.material)

    implementation(Dependency.Accompanist.insets)
    implementation(Dependency.Accompanist.navigationAnimation)
    implementation(Dependency.Accompanist.systemUIController)
    implementation(Dependency.Accompanist.pager)

    implementation(Dependency.Koin.android)
    implementation(Dependency.Koin.core)

    implementation(Dependency.Loggers.timber)
    implementation(Dependency.Loggers.prettyLogger)
}
