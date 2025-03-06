pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CoursAndroid"
include(":app")
include(":mod1demo1")
include(":mod1demo2")
include(":mod3demo1")
include(":mod3demo2")
include(":mod3demo3")
include(":mod3demo4")
include(":mod3demo5")
include(":mod4demo1")
include(":mod4demo2")
include(":mod4tp1")
