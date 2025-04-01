package dev.trindadedev.exp.navigation.navtype

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

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import dev.trindadedev.exp.api.models.Project
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// used in Navigation to send Project model

object CustomNavType {

  val ProjectType =
    object : NavType<Project>(isNullableAllowed = false) {
      override fun get(bundle: Bundle, key: String): Project? {
        return Json.decodeFromString(bundle.getString(key) ?: return null)
      }

      override fun parseValue(value: String): Project {
        return Json.decodeFromString(Uri.decode(value))
      }

      override fun serializeAsValue(value: Project): String {
        return Uri.encode(Json.encodeToString(value))
      }

      override fun put(bundle: Bundle, key: String, value: Project) {
        bundle.putString(key, Json.encodeToString(value))
      }
    }
}
