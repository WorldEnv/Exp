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

@SuppressWarnings("unused")
object VersionUtils {
  const val versionCode = 1
  const val version = "1.0.0"

  val versionName by lazy {
    if (CI.isCiBuild && CI.branchName != "main") {
      "$version-${CI.branchName}@${CI.commitHash}"
    } else version
  }
}
