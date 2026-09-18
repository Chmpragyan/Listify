// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("androidx.room") version "2.7.2" apply false
    alias(libs.plugins.sonar)
}

sonar {
    properties {
        property("sonar.projectKey", "chmpragyan_Listify")
        property("sonar.projectName", "Listify")
        property("sonar.organization", "chmpragyan")
        property("sonar.host.url", "https://sonarcloud.io")
        
        // Android specific coverage and reports
        property("sonar.junit.reportPaths", "app/build/test-results/testDebugUnitTest")
        property("sonar.coverage.jacoco.xmlReportPaths", "app/build/reports/jacoco/jacocoTestReport/jacocoTestReport.xml")
        property("sonar.android.lint.report", "app/build/reports/lint-results-debug.xml")
        
        // Fix for branch detection if needed
        property("sonar.scm.provider", "git")
    }
}