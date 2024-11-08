package dev.trindadedev.exp

/*
 *  This file is part of Exp © 2024.
 *
 *  Exp is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Exp is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Exp.  If not, see <https://www.gnu.org/licenses/>.
 */

import android.app.Application

import dev.trindadedev.exp.di.NetworkModule

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
      modules(NetworkModule)
    }
  }
}
