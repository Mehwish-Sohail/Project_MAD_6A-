plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.FITNESSAPP"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.FITNESSAPP"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
//    implementation(libs.play.services.ads.lite)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.19")
    implementation("com.google.android.material:material:1.12.0")
   implementation ("com.google.android.gms:play-services-ads:23.0.0")
//    implementation ("androidx.appcompat:appcompat:1.3.1")
//    implementation ("androidx.core:core-ktx:1.6.0")
        // Other dependencies
    }


