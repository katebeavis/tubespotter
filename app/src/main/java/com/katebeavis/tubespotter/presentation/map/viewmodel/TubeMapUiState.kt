package com.katebeavis.tubespotter.presentation.map.viewmodel

import com.katebeavis.tubespotter.domain.usecase.MapStation
import com.katebeavis.tubespotter.presentation.common.mvi.UiState

data class TubeMapUiState(
    val stations: List<MapStation> = emptyList(),
) : UiState