package com.katebeavis.tubespotter.presentation.stationlist.viewmodel

import com.katebeavis.tubespotter.domain.model.Line
import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.presentation.common.mvi.UiState

data class StationListUiState(
    val stations: List<Station> = emptyList(),
    val lines: List<Line> = emptyList(),
    val selectedLineId: Int? = null,
    val visitedCount: Int = 0,
    val totalCount: Int = 0,
) : UiState