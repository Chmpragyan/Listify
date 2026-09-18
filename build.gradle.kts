// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("androidx.room") version "2.7.2" apply false
    alias(libs.plugins.sonar)
}

sonarqube {
    properties {
        property("sonar.projectKey", "chmpragyan_Listify")
        property("sonar.projectName", "Listify")
        property("sonar.organization", "chmpragyan")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.sources", "app/src/main/java")
    }
}