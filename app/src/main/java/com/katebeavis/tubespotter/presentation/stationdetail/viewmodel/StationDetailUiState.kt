package com.katebeavis.tubespotter.presentation.stationdetail.viewmodel

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.presentation.common.mvi.UiState

sealed interface StationDetailUiState : UiState {
    data object Loading : StationDetailUiState
    data class Content(val station: Station) : StationDetailUiState
}