package dev.trindadedev.exp.navigation

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
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.navigation.navtype.CustomNavType
import dev.trindadedev.exp.navigation.routes.*
import dev.trindadedev.exp.platform.LocalMainNavController
import dev.trindadedev.exp.ui.animations.navigation.NavigationAnimationTransitions
import dev.trindadedev.exp.ui.screens.home.HomeScreen
import dev.trindadedev.exp.ui.screens.project.details.ProjectDetailsScreen
import kotlin.reflect.typeOf

@Composable
fun MainNavHost() {
  val navController = LocalMainNavController.current

  NavHost(
    navController = navController,
    startDestination = HomeRoute,
    enterTransition = { NavigationAnimationTransitions.enterTransition },
    exitTransition = { NavigationAnimationTransitions.exitTransition },
    popEnterTransition = { NavigationAnimationTransitions.popEnterTransition },
    popExitTransition = { NavigationAnimationTransitions.popExitTransition },
  ) {
    composable<HomeRoute> {
      HomeScreen(
        onProjectClicked = { project ->
          navController.navigate(ProjectDetailsRoute(project = project))
          Log.d("Project", project.toString())
        }
      )
    }

    composable<ProjectDetailsRoute>(
      typeMap = mapOf(typeOf<Project>() to CustomNavType.ProjectType)
    ) {
      val args = it.toRoute<ProjectDetailsRoute>()
      ProjectDetailsScreen(project = args.project)
    }
  }
}
