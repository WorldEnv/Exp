package dev.trindadedev.exp.ui.animations.navigation

import soup.compose.material.motion.animation.materialSharedAxisYIn
import soup.compose.material.motion.animation.materialSharedAxisYOut

/*
 * object that return needed transitions of Navigation anims
 */
object NavigationAnimationTransitions {

  val enterTransition =
    materialSharedAxisYIn(
      forward = true,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )

  val exitTransition =
    materialSharedAxisYOut(
      forward = true,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )

  val popEnterTransition =
    materialSharedAxisYIn(
      forward = false,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )

  val popExitTransition =
    materialSharedAxisYOut(
      forward = false,
      slideDistance = NavigationAnimationValues.SlideDistance,
      durationMillis = NavigationAnimationValues.SlideDuration,
    )
}
