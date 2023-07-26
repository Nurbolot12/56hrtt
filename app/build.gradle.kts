plugins {
    id(Plugins.AGP.application);
    id(Plugins.Kotlin.android);
    id(Plugins.Kotlin.kapt);
    id(Plugins.DaggerHilt.hilt);
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = 33
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = AppConfig.TestInstrumentation
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.compatibility
        targetCompatibility = AppConfig.compatibility
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Deps.Ui.core)
    implementation(Deps.Ui.appcompat)
    implementation(Deps.Ui.material)
    implementation(Deps.Ui.constraint)
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.extJunit)
    androidTestImplementation(Deps.Test.espresso)


    // Room
    implementation(Deps.Room.runtime)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.room)


    // Hilt
    implementation(Deps.DaggerHilt.android)
    implementation(Deps.DaggerHilt.core)
    kapt(Deps.DaggerHilt.compiler)

    //nav graph

    implementation(Deps.NavGraph.fragment)
    implementation(Deps.NavGraph.ui)

    // Lifecycle
    implementation(Deps.Lifecycle.viewModel)
    implementation(Deps.Lifecycle.runtime)

    //Fragment
    implementation(Deps.Ui.fragment)
}