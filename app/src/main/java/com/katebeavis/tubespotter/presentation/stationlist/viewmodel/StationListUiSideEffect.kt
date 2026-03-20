package com.katebeavis.tubespotter.presentation.stationlist.viewmodel

import com.katebeavis.tubespotter.presentation.common.mvi.UiSideEffect

sealed interface StationListUiSideEffect : UiSideEffect {
    data class LaunchCamera(val stationId: Int, val uri: String) : StationListUiSideEffect
    data class ShowDeleteConfirmation(val stationId: Int, val uri: String) : StationListUiSideEffect
}