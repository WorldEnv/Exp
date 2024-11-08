package dev.trindadedev.exp.ui.animations.navigation

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
