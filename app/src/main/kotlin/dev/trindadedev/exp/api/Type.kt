package dev.trindadedev.exp.api

/*
 * projects types
 */
enum class Type(val label: String, val id: String?) {
  RECENT(label = "Recents", id = null),
  EDITOR_CHOICE(label = "Editor's Choice", id = "editor_choice"),
  MOST_DOWNLOADED(label = "Most Downloaded", id = "most_downloaded"),
}
