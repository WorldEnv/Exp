package dev.trindadedev.exp.di

import dev.trindadedev.exp.api.ApiViewModel
import dev.trindadedev.exp.api.repo.ProjectsRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/*
 * apo module
 */
val moduleApp = module {
  singleOf(::ProjectsRepository)
  viewModelOf(::ApiViewModel)
}

/*
 * Module for ktor repo dependency injection
 */
val moduleNetwork = module {
  single {
    HttpClient(Android) { install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) } }
  }
}
