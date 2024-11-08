package dev.trindadedev.exp.ui.screens.project.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.input.nestedscroll.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import dev.trindadedev.exp.Strings
import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailsScreen(project: Project) {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
  val scrollState = rememberScrollState()

  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      TopBar(
        title = { Text(stringResource(id = Strings.label_project_details)) },
        scrollBehavior = scrollBehavior,
      )
    },
  ) { innerPadding ->
    Column(Modifier.padding(innerPadding).verticalScroll(scrollState)) {}
  }
}
