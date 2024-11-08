package dev.trindadedev.exp.ui.screens.home.components

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

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import coil3.compose.AsyncImage
import dev.trindadedev.exp.api.models.Project

/*
 * A Column with projects list for home or something
 * @param label title of section
 * @param projects list of projects
 * @param onProjectClicked function called when user click in project
 * see @Composable ProjectsList
 */
@Composable
fun Section(label: String, projects: List<Project>, onProjectClicked: (Project) -> Unit) {
  val scrollState = rememberScrollState()
  Column {
    Text(
      text = label,
      style = MaterialTheme.typography.titleLarge,
      modifier = Modifier.padding(8.dp),
    )
    Row(modifier = Modifier.horizontalScroll(scrollState)) {
      ProjectsList(projects = projects, onProjectClicked = { onProjectClicked(it) })
    }
  }
}

/*
 * A Simple Horizontal List of Projects
 * @param projects list of projects
 * @param onProjectClicked function called when user click in project
 * used on @Composable Section
 */
@Composable
private fun ProjectsList(projects: List<Project>, onProjectClicked: (Project) -> Unit) {
  projects.forEach { project ->
    ProjectItem(project = project, onProjectClicked = { onProjectClicked(it) })
  }
}

/*
 * A Item Layout of Project
 * @param project A data class of current project
 * @param onProjectClicked function called when user click in project and return project
 */
@Composable
private fun ProjectItem(
  project: Project, 
  onProjectClicked: (Project) -> Unit
) {
  OutlinedCard(
    modifier =
      Modifier.width(130.dp).padding(end = 8.dp, start = 8.dp).clickable {
        onProjectClicked(project)
      },
    shape = MaterialTheme.shapes.large,
    colors =
      CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      ProjectItemIcon(model = project.icon)
      Spacer(modifier = Modifier.height(8.dp))
      ProjectItemTitle(title = project.title)
      Spacer(modifier = Modifier.height(4.dp))
      ProjectItemInfo(
        likes = project.likes.toString(),
        downloads = project.downloads.toString()
      )
    }
  }
}

/*
 * A Title of ProjectItem
 * @param title A String of Title value
 */
@Composable
private fun ProjectItemTitle(title: String) {
  Text(
    text = title,
    style = MaterialTheme.typography.titleMedium
      .copy(fontWeight = FontWeight.Bold),
    overflow = TextOverflow.Ellipsis,
    maxLines = 1,
    modifier = Modifier.padding(horizontal = 8.dp),
  )
}

/*
 * A Icon of Project
 * @param model a Url of project icon
 */
@Composable
private fun ProjectItemIcon(model: String) {
  AsyncImage(
    model = model,
    contentDescription = "Project Image",
    contentScale = ContentScale.Crop,
    modifier = Modifier
      .fillMaxWidth()
      .height(100.dp)
      .clip(RoundedCornerShape(0.dp)),
  )
}

/*
 * A Basic Infos of Project
 * @param likes A string of likes count
 * @param downloads A string of downloads count
 */
@Composable
private fun ProjectItemInfo(
  likes: String,
  downloads: String
) {
  Column(
    modifier = Modifier.fillMaxWidth()
      .padding(horizontal = 8.dp, vertical = 10.dp)
  ) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
      Icon(
        imageVector = Icons.Filled.Favorite,
        contentDescription = "Likes",
        tint = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.size(15.dp),
      )
      Spacer(modifier = Modifier.width(4.dp))
      Text(
        text = likes,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
    Spacer(modifier = Modifier.height(6.dp))
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
      Icon(
        imageVector = Icons.Filled.CloudDownload,
        contentDescription = "Downloads",
        modifier = Modifier.size(15.dp),
      )
      Spacer(modifier = Modifier.width(4.dp))
      Text(
        text = downloads,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
  }
}