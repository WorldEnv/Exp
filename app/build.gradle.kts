plugins {
  alias(libs.plugins.agp.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "dev.trindadedev.exp"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    applicationId = "dev.trindadedev.exp"
    versionCode = 1
    versionName = "1.0"
    
    vectorDrawables.useSupportLibrary = true
    
    buildConfigField("String", "SKETCHUB_API_KEY", "\"${System.getenv("SKETCHUB_API_KEY") ?: ""}\"")
  }
  
  compileOptions {
    sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
  }
    
  kotlinOptions {
    jvmTarget = libs.versions.android.jvm.get()
  }
    
  buildFeatures {
    compose = true
    buildConfig = true
  }
    
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
    
  signingConfigs {
    create("release") {
      // temporary keystore
      storeFile = file(layout.buildDirectory.dir("../release_key.jks"))
      storePassword = "release_temp"
      keyAlias = "release_temp"
      keyPassword = "release_temp"
    }
    getByName("debug") {
      storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
      storePassword = "testkey"
      keyAlias = "testkey"
      keyPassword = "testkey"
    }
  }
    
  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("release")
    }
  }
}

dependencies {
  implementation(platform(libs.compose.bom))
  
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.core.splashscreen)
  implementation(libs.androidx.lifecycle.runtime.ktx)
    
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.graphics)
  implementation(libs.compose.activity)
  implementation(libs.compose.material.motion.core)
  implementation(libs.compose.material.icons)
  implementation(libs.compose.material3)
  implementation(libs.compose.navigation)
  implementation(libs.compose.coil)
    
  implementation(libs.coil.network.okhttp)
    
  implementation(libs.kotlinx.serialization.json)
    
  implementation(libs.ktor.client.android)
  implementation(libs.ktor.client.content.negotiation)
  implementation(libs.ktor.serialization.kotlix.json)
    
  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)
    
  implementation(libs.slf4j)
}