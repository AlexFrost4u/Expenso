import com.android.build.gradle.BaseExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN

plugins {
    id(Plugins.ktlint) version Version.ktlintJLLeitschuh
    id(Plugins.detekt) version Version.detekt
    id(Plugins.koin) version Version.koin
    id(Plugins.spotless) version Version.spotless
    id(Plugins.gradleVersions) version Version.gradleVersions
    kotlin(Plugins.android) version Version.kotlin apply false
    id(Plugins.androidApplication) version Version.androidGradle apply false
    id(Plugins.androidLibrary) version Version.androidGradle apply false
    /**
     * Remove the hardcoded plugins added below when creating a new module to avoid build errors.
     */
}

// all projects = root project + sub projects
allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

    apply {
        // We want to apply ktlint at all project level because it also checks Gradle config files (*.kts)
        plugin(Plugins.ktlint)
        plugin(Plugins.spotless)
        plugin(Plugins.detekt)
        plugin(Plugins.koin)
    }

    configureKtlint()
    configureSpotless()
    configDetekt()
}

subprojects {
    afterEvaluate {
        configureAndroid()
    }
}

tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

/**
 * Static code analyzers
 */

fun Project.configDetekt() {
    detekt {
        config = files("$rootDir/detekt.yml")

        parallel = true

        // By default detekt does not check test source set and gradle specific files, so hey have to be added manually
        source = files(
            "$rootDir/buildSrc",
            "$rootDir/build.gradle.kts",
            "$rootDir/settings.gradle.kts",
            "src/main/kotlin",
            "src/test/kotlin"
        )

        autoCorrect = true
    }
}

fun Project.configureSpotless() {
    spotless {
        java {
            target("**/*.java")
            googleJavaFormat().aosp()
            removeUnusedImports()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
        kotlin {
            target("**/*.kt")
            // ktlint()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
        format("misc") {
            target("**/*.gradle", "**/*.md", "**/.gitignore")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }

        kotlinGradle {
            target("*.gradle.kts")
            ktlint()
        }

        format("xml") {
            target("**/*.xml")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
    }
}

fun Project.configureKtlint() {
    // Ktlint configuration for sub-projects
    ktlint {
        // Version of ktlint cmd tool (Ktlint Gradle plugin is just a wrapper for this tool)
        version.set(Version.ktlint)
        debug.set(true)
        verbose.set(true)
        android.set(true)
        outputToConsole.set(true)
        outputColorName.set("BLUE")
        ignoreFailures.set(true)
        enableExperimentalRules.set(true)

        // Uncomment below line and run .\gradlew ktlintCheck to see check ktlint experimental rules
        // enableExperimentalRules.set(true)

        reporters {
            reporter(PLAIN)
            reporter(CHECKSTYLE)
        }

        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

fun Project.configureAndroid() {
    (project.extensions.findByName("android") as? BaseExtension)?.run {
        compileSdkVersion(AndroidConfig.compileSdk)

        defaultConfig {
            minSdk = AndroidConfig.minSdk
            targetSdk = AndroidConfig.targetSdk
            buildToolsVersion(AndroidConfig.buildTools)

            versionCode = AndroidConfig.versionCode
            versionName = AndroidConfig.versionName
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        sourceSets.all {
            java.srcDir("src/$name/kotlin")
        }
    }
}
// #Remove if swears when using the 'spotless' plugin
// tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
// }
