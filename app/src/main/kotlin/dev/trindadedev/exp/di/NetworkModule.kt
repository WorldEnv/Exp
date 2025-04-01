package dev.trindadedev.exp.di

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

import dev.trindadedev.exp.api.repository.ProjectsRepository
import dev.trindadedev.exp.api.viewmodel.ProjectsViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/*
 * Network Module (KTOR)
 */
val NetworkModule = module {
  singleOf(::ProjectsRepository)
  viewModelOf(::ProjectsViewModel)
  single {
    HttpClient(Android) { install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) } }
  }
}
