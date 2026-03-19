package com.katebeavis.tubespotter.presentation.stationlist.viewmodel

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.presentation.common.mvi.UiAction

sealed interface StationListUiAction : UiAction {
    data class ToggleStation(val station: Station) : StationListUiAction
}