package com.katebeavis.tubespotter.presentation.stationdetail.viewmodel

import com.katebeavis.tubespotter.presentation.common.mvi.UiAction

sealed interface StationDetailUiAction : UiAction {
    data object ToggleVisited : StationDetailUiAction
    data object NavigateBack : StationDetailUiAction
}