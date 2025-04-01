package dev.trindadedev.exp.api.viewmodel

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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.trindadedev.exp.api.Type
import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.api.repository.ProjectsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/*
 * View model used for manage Api projects  etc
 */

class ProjectsViewModel(private val repo: ProjectsRepository) : ViewModel() {

  // private lists of projects
  private val _editorChoiceProjects = MutableStateFlow<List<Project>>(emptyList())
  private val _mostDownloadedProjects = MutableStateFlow<List<Project>>(emptyList())
  private val _recentProjects = MutableStateFlow<List<Project>>(emptyList())

  // lists with projects by type
  val editorChoiceProjects: StateFlow<List<Project>>
    get() = _editorChoiceProjects

  val mostDownloadedProjects: StateFlow<List<Project>>
    get() = _mostDownloadedProjects

  val recentProjects: StateFlow<List<Project>>
    get() = _recentProjects

  private val _error = MutableStateFlow<String?>(null)
  val error: StateFlow<String?>
    get() = _error

  init {
    getEditorChoiceProjects()
    getMostDownloadedProjects()
    getRecentProjects()
  }

  /*
   * use ProjectsRepo to get Editor Choice Projects
   */
  private fun getEditorChoiceProjects() {
    viewModelScope.launch {
      try {
        _editorChoiceProjects.value = repo.getProjects(Type.EDITOR_CHOICE)
      } catch (e: Exception) {
        _error.value = e.message
      }
    }
  }

  /*
   * use ProjectsRepo to get Most Downloaded Projects
   */
  private fun getMostDownloadedProjects() {
    viewModelScope.launch {
      try {
        _mostDownloadedProjects.value = repo.getProjects(Type.MOST_DOWNLOADED)
      } catch (e: Exception) {
        _error.value = e.message
      }
    }
  }

  /*
   * use ProjectsRepo to get Recents Projects
   */
  private fun getRecentProjects() {
    viewModelScope.launch {
      try {
        _recentProjects.value = repo.getProjects(Type.RECENT)
      } catch (e: Exception) {
        _error.value = e.message
      }
    }
  }
}
