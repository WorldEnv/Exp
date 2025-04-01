package dev.trindadedev.exp.ui.components

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

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

/*
 * A Basic small TopAppBar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
  title: @Composable () -> Unit,
  scrollBehavior: TopAppBarScrollBehavior,
  navigationIcon: @Composable (() -> Unit)? = null,
  actions: @Composable RowScope.() -> Unit = {},
  isLarge: Boolean = false,
) {
  if (!isLarge) {
    TopAppBar(
      title = title,
      navigationIcon = { navigationIcon?.let { it() } },
      actions = actions,
      scrollBehavior = scrollBehavior,
    )
  } else {
    LargeTopAppBar(
      title = title,
      navigationIcon = { navigationIcon?.let { it() } },
      actions = actions,
      scrollBehavior = scrollBehavior,
    )
  }
}
