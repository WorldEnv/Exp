package dev.trindadedev.exp.api

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

/*
 * Constants used in api request
 */

import dev.trindadedev.exp.BuildConfig

object Consts {

  // sketchub api url
  const val URL = "https://sketchub.in/api/v3/"

  // routes to get api data
  object Routes {
    const val PROJECTS_ROUTE = "get_project_list"
  }

  // tokens
  object Tokens {
    const val API_KEY = BuildConfig.SKETCHUB_API_KEY
  }
}
