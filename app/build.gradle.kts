import dev.trindadedev.exp.build.BuildConfig
import dev.trindadedev.exp.build.BuildConfig.Secrets
import dev.trindadedev.exp.build.VersionUtils

plugins {
  alias(libs.plugins.exp.application)
  alias(libs.plugins.exp.compose)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = BuildConfig.packageName
  
  defaultConfig {
    applicationId = namespace
    versionCode = VersionUtils.versionCode
    versionName = VersionUtils.versionName
    
    vectorDrawables.useSupportLibrary = true
    
    buildConfigField("String", "SKETCHUB_API_KEY", Secrets.sketchubApiKey)
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
    
  implementation(libs.compose.material.motion.core)
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