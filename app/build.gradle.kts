plugins {
    id("kotlin-kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.boxpay_juspay_checkout_android_sdk"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.boxpay_juspay_checkout_android_sdk"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
    kapt {
        correctErrorTypes = true
    }

    viewBinding {
        enable = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.constraintlayout)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.dagger:hilt-android:2.51.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")  
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("androidx.compose.material:material-icons-extended:1.3.1")
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")
    implementation("com.google.accompanist:accompanist-permissions:0.19.0")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.24.13-rc")
    implementation("androidx.compose.material:material")
    implementation("com.github.BoxPay-SDKs:checkout-android-sdk:1.1.14")
    implementation ("com.android.volley:volley:1.2.1")
}