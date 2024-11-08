package dev.trindadedev.exp.navigation.routes

import dev.trindadedev.exp.api.models.Project
import kotlinx.serialization.Serializable

@Serializable object HomeRoute

@Serializable data class ProjectDetailsRoute(val project: Project)
