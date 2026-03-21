package com.katebeavis.tubespotter.presentation.map.viewmodel

import com.katebeavis.tubespotter.presentation.common.mvi.UiSideEffect

sealed interface TubeMapUiSideEffect : UiSideEffect {
    data class NavigateToDetail(val stationId: Int) : TubeMapUiSideEffect
}