package dev.trindadedev.exp.build

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

import java.io.File

object CI {

  /*
   * The short commit hash.
   */
  val commitHash by lazy {
    val sha = System.getenv("GITHUB_SHA") ?: return@lazy ""
    shortSha(sha)
  }

  /*
   * Name of the current branch. 
   */
  val branchName by lazy {
    System.getenv("GITHUB_REF_NAME") ?: "dev"
  }

  /*
   * Whether the current build is a CI build. 
   */
  val isCiBuild by lazy {
    "true" == System.getenv("CI") 
  }

  private fun shortSha(sha: String): String {
    return ProcessBuilder("git", "rev-parse", "--short", sha)
      .directory(File("."))
      .redirectErrorStream(true)
      .start()
      .inputStream
      .bufferedReader()
      .readText()
      .trim()
  }
  
  /*
   * GitHub Secrets
   */
  object Secrets {
    /*
     * Sketchub Api Key for api
     */
    val sketchubApiKey by lazy {
      System.getenv("SKETCHUB_API_KEY") ?: ""
    }
  }
}
