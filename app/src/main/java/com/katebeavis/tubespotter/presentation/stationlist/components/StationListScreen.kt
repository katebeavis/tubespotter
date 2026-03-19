package com.katebeavis.tubespotter.presentation.stationlist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.presentation.stationlist.viewmodel.StationListUiAction
import com.katebeavis.tubespotter.presentation.stationlist.viewmodel.StationListUiState
import com.katebeavis.tubespotter.presentation.stationlist.viewmodel.StationListViewModel

@Composable
fun StationListScreen(
    viewModel: StationListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    StationListContent(
        uiState = uiState,
        onToggleStation = { viewModel.postAction(
            StationListUiAction.ToggleStation(it)
        )},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StationListContent(
    uiState: StationListUiState,
    onToggleStation: (Station) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TubeSpotter — ${uiState.visitedCount} / ${uiState.totalCount}") }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            LazyColumn {
                items(
                    items = uiState.stations,
                    key = { it.id },
                ) { station ->
                    StationItem(
                        station = station,
                        onToggle = onToggleStation,
                    )
                }
            }
        }
    }
}