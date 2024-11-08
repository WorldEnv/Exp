package dev.trindadedev.exp.navigation.navtype

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
