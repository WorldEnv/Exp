package dev.trindadedev.exp.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.input.nestedscroll.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import dev.trindadedev.exp.Strings
import dev.trindadedev.exp.api.ApiViewModel
import dev.trindadedev.exp.api.Type
import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.ui.components.TopBar
import dev.trindadedev.exp.ui.screens.home.components.Section
import dev.trindadedev.exp.ui.screens.home.components.SectionPager
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onProjectClicked: (Project) -> Unit) {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
  val scrollState = rememberScrollState()

  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      TopBar(
        title = { Text(stringResource(id = Strings.app_name)) },
        scrollBehavior = scrollBehavior,
      )
    },
  ) { innerPadding ->
    Column(Modifier.padding(innerPadding).verticalScroll(scrollState)) {
      Sections { onProjectClicked(it) }
    }
  }
}

/*
 * All sections on Home
 * @param onProjectClicked function called when user click in project
 */
@Composable
private fun Sections(onProjectClicked: (Project) -> Unit) {
  val apiViewModel = koinViewModel<ApiViewModel>()

  val editorChoiceProjects by
    apiViewModel.editorChoiceProjects.collectAsState(initial = emptyList())
  val mostDownloadedProjects by
    apiViewModel.mostDownloadedProjects.collectAsState(initial = emptyList())
  val recentProjects by apiViewModel.recentProjects.collectAsState(initial = emptyList())

  SectionPager(
    label = Type.EDITOR_CHOICE.label,
    projects = editorChoiceProjects,
    onProjectClicked = { onProjectClicked(it) },
  )

  Section(
    label = Type.MOST_DOWNLOADED.label,
    projects = mostDownloadedProjects,
    onProjectClicked = { onProjectClicked(it) },
  )

  Section(
    label = Type.RECENT.label,
    projects = recentProjects,
    onProjectClicked = { onProjectClicked(it) },
  )
}
