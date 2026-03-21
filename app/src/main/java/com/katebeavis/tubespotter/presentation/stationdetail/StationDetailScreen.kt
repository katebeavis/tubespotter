package com.katebeavis.tubespotter.presentation.stationdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.presentation.stationdetail.viewmodel.StationDetailUiAction
import com.katebeavis.tubespotter.presentation.stationdetail.viewmodel.StationDetailUiSideEffect
import com.katebeavis.tubespotter.presentation.stationdetail.viewmodel.StationDetailUiState
import com.katebeavis.tubespotter.presentation.stationdetail.viewmodel.StationDetailViewModel

@Composable
fun StationDetailScreen(
    stationId: Int,
    onBack: () -> Unit,
    viewModel: StationDetailViewModel = hiltViewModel<StationDetailViewModel, StationDetailViewModel.Factory>(
        key = stationId.toString(),
        creationCallback = { factory -> factory.create(stationId) }
    ),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                StationDetailUiSideEffect.GoBack -> onBack()
            }
        }
    }

    StationDetailContent(
        uiState = uiState,
        onAction = viewModel::postAction,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StationDetailContent(
    uiState: StationDetailUiState,
    onAction: (StationDetailUiAction) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val title = when (uiState) {
                        is StationDetailUiState.Content -> uiState.station.name
                        StationDetailUiState.Loading -> "Loading..."
                    }
                    Text(title)
                },
                navigationIcon = {
                    IconButton(onClick = { onAction(StationDetailUiAction.NavigateBack) }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        when (uiState) {
            StationDetailUiState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    CircularProgressIndicator()
                }
            }
            is StationDetailUiState.Content -> {
                StationDetailBody(
                    station = uiState.station,
                    onAction = onAction,
                    modifier = Modifier.padding(paddingValues),
                )
            }
        }
    }
}

@Composable
private fun StationDetailBody(
    station: Station,
    onAction: (StationDetailUiAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = station.name,
            style = MaterialTheme.typography.headlineMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Zone ${station.zone}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = if (station.isVisited) "Visited" else "Not visited",
                style = MaterialTheme.typography.bodyLarge,
            )
            Button(onClick = { onAction(StationDetailUiAction.ToggleVisited) }) {
                Text(if (station.isVisited) "Mark unvisited" else "Mark visited")
            }
        }
    }
}