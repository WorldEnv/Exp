plugins {
  `kotlin-dsl`
}

dependencies {
  compileOnly(libs.android.gradle)
  compileOnly(libs.compose.gradle)
  compileOnly(libs.kotlin.gradle)
  compileOnly(libs.ksp.gradle)
}

gradlePlugin {
  plugins {
    register("exp.application") {
      id = "exp.application"
      implementationClass = "ApplicationConventionPlugin"
    }
    
    register("exp.library") {
      id = "exp.library"
      implementationClass = "LibraryConventionPlugin"
    }
    
    register("exp.compose") {
      id = "exp.compose"
      implementationClass = "ComposeConventionPlugin"
    }
  }
}