package dev.trindadedev.exp.api

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
