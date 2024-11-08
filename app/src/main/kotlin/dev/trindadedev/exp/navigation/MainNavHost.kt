package dev.trindadedev.exp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.navigation.navtype.CustomNavType
import dev.trindadedev.exp.navigation.routes.HomeRoute
import dev.trindadedev.exp.navigation.routes.ProjectDetailsRoute
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
