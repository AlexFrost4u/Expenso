@file:Suppress("detekt.StringLiteralDuplication")

object Plugins {
    const val android = "android"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"

    const val kapt = "kotlin-kapt"

    // Updates versions
    const val gradleVersions = "com.github.ben-manes.versions"

    // Static analysis plugins
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val ktlint = "org.jlleitschuh.gradle.ktlint"
    const val spotless = "com.diffplug.spotless"

    // Koin
    const val koin = "koin"
}

object Dependency {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Version.kotlin}"
    }

    object Coroutines {
        private const val version = "1.6.1"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val material = "com.google.android.material:material:1.5.0"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-rc01"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0-beta01"

        object Compose {
            private const val version = "1.1.1"

            const val compiler = "androidx.compose.compiler:compiler:${Version.composeCompiler}"
            const val ui = "androidx.compose.ui:ui:${version}"
            const val material = "androidx.compose.material:material:${version}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${version}"
            const val tooling = "androidx.compose.ui:ui-tooling:${version}"
            const val foundation = "androidx.compose.foundation:foundation:${version}"
            const val runtime = "androidx.compose.runtime:runtime:${version}"
        }

        object DataStore {
            private const val version = "1.0.0"

            const val preferences = "androidx.datastore:datastore-preferences:$version"
        }

        object Lifecycle {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"

        }
    }

    object Loggers {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
        const val prettyLogger = "com.orhanobut:logger:2.2.0"
        const val kotlinLogging = "io.github.microutils:kotlin-logging-jvm:2.1.21"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.3"

        object OkHTTP {
            private const val version = "4.9.3"

            // Must be implemented with implementation (platform (..))
            const val bom = "com.squareup.okhttp3:okhttp-bom:$version"
            const val core = "com.squareup.okhttp3:okhttp"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
        }

        object Moshi {
            const val converterMoshi = "com.squareup.retrofit2:converter-moshi:2.9.0"
            const val moshi = "com.squareup.moshi:moshi:1.13.0"
            const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:1.13.0"
        }
    }

    // Wait for proper savedStateHandle passage to viewModel
    object Koin {
        private const val version = "3.1.6"

        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
        const val tests = "io.insert-kobuin:koin-test:$version"
    }

    object Accompanist {
        private const val version = "0.23.1"

        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pager_indicators = "com.google.accompanist:accompanist-pager-indicators:$version"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val navigationMaterial =
            "com.google.accompanist:accompanist-navigation-animation:$version"
        const val navigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:$version"
        const val systemUIController =
            "com.google.accompanist:accompanist-systemuicontroller:$version"
    }

    object Tests {
        object Kotest {
            private const val version = "5.1.0"

            const val framework = "io.kotest:kotest-runner-junit5:$version"
            const val assertions = "io.kotest:kotest-assertions-core:$version"
        }
    }

    object Other {
        const val libphonenumber = "com.googlecode.libphonenumber:libphonenumber:8.12.3"
        const val coil = "io.coil-kt:coil-compose:1.4.0"
        const val sandwich = "com.github.skydoves:sandwich:1.2.4"
        const val mviOrbit = "org.orbit-mvi:orbit-viewmodel:4.3.2"
        const val klock = "com.soywiz.korlibs.klock:klock:2.4.13"
        const val ksprefs = "com.github.cioccarellia:ksprefs:2.3.2"
    }
}
