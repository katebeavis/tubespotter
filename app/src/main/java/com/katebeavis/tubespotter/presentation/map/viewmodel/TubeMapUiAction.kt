package com.katebeavis.tubespotter.presentation.map.viewmodel

import com.katebeavis.tubespotter.presentation.common.mvi.UiAction

sealed interface TubeMapUiAction : UiAction {
    data class StationTapped(val stationId: Int) : TubeMapUiAction
}