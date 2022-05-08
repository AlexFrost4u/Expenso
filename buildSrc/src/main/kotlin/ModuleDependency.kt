object ModuleDependency {
    const val app = ":app"

    object Core {
        private const val base = ":core"

        const val common = "$base:common"
        const val ui = "$base:ui"
    }
}
