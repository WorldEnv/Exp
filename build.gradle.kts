plugins {
  id("build-logic.root-project")
  alias(libs.plugins.agp.library) apply false
  alias(libs.plugins.agp.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.compose.compiler) apply false
}

tasks.register<Delete>("clean") {
  delete(rootProject.buildDir)
}