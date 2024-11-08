package dev.trindadedev.exp.api.repository

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

import android.util.Log

import dev.trindadedev.exp.api.Consts.Routes.PROJECTS_ROUTE
import dev.trindadedev.exp.api.Consts.Tokens.API_KEY
import dev.trindadedev.exp.api.Consts.URL
import dev.trindadedev.exp.api.Type
import dev.trindadedev.exp.api.models.Response
import dev.trindadedev.exp.api.models.Project

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ProjectsRepository(private val httpClient: HttpClient) {

  /*
   * Method to get projects from api with KTOR
   * @param type Type of projects
   */
  suspend fun getProjects(type: Type): List<Project> {
    val response: HttpResponse =
      httpClient.submitForm(
        url = "$URL$PROJECTS_ROUTE",
        formParameters =
          parameters {
            append("api_key", API_KEY)
            if (type.id != null) {
              append("scope", type.id)
            }
          },
      )

    Log.d("ProjectsRepository::getProjectsL31", response.body())
    val json = Json { ignoreUnknownKeys = true }

    if (response.status.value in 200..299) {
      val responseBody: String = response.body()

      val apiResponse: Response = json.decodeFromString(responseBody)

      return apiResponse.projects
    } else {
      throw Exception("error lol: ${response.status}")
    }
  }
}
