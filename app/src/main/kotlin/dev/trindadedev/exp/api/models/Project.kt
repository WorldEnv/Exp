package dev.trindadedev.exp.api.models

import kotlinx.serialization.Serializable

/*
 * Model class used to manage project data
 */
@Serializable
data class Project(
  val id: String,
  val title: String,
  val description: String,
  val whatsnew: String,
  val category: String,
  val project_type: String,
  val demo_link: String?,
  val video_url: String?,
  val icon: String,
  val screenshot1: String,
  val screenshot2: String,
  val screenshot3: String,
  val screenshot4: String?,
  val screenshot5: String?,
  val project_size: String,
  val likes: String,
  val comments: String,
  val downloads: String,
  val uid: String,
  val timestamp: String,
  val published_timestamp: String,
  val is_verified: String,
  val is_editor_choice: String,
  val user_name: String,
  val user_profile_pic: String,
  val user_badge: String,
)
