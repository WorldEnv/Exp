package dev.trindadedev.exp

import android.app.Application
import dev.trindadedev.exp.di.moduleApp
import dev.trindadedev.exp.di.moduleNetwork
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExpApp : Application() {

  override fun onCreate() {
    super.onCreate()
    configureKoin()
  }

  /*
   * Start koin for dependency injection
   */
  fun configureKoin() {
    startKoin {
      androidContext(this@ExpApp)
      modules(moduleApp, moduleNetwork)
    }
  }
}
