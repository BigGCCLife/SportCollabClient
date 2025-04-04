// Top-level build file where you can add configuration options common to all sub-projects/modules.

// import java.util.Properties
// // Declare a top-level property using lazy initialization
// val mapkitApiKey: String by lazy {
//     val properties = Properties()
//     file("local.properties").inputStream().use { properties.load(it) }
//     properties.getProperty("MAPKIT_API_KEY", "")
// }
//
// // Expose it to subprojects
// extra["mapkitApiKey"] = mapkitApiKey

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}
