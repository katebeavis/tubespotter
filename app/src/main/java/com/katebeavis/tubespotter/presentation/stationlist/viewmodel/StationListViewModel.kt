package com.katebeavis.tubespotter.presentation.stationlist.viewmodel

import androidx.lifecycle.viewModelScope
import com.katebeavis.tubespotter.domain.usecase.GetAllStationsUseCase
import com.katebeavis.tubespotter.domain.usecase.ToggleStationVisitedUseCase
import com.katebeavis.tubespotter.presentation.common.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationListViewModel @Inject constructor(
    private val getAllStations: GetAllStationsUseCase,
    private val toggleStationVisited: ToggleStationVisitedUseCase,
) : BaseViewModel<StationListUiState, StationListUiAction, StationListUiSideEffect>(
    initialState = StationListUiState()
) {

    init {
        observeStations()
    }

    override fun handleAction(action: StationListUiAction) {
        when (action) {
            is StationListUiAction.ToggleStation -> toggleStation(action.station)
        }
    }

    private fun observeStations() {
        getAllStations()
            .onEach { stations ->
                updateState {
                    copy(
                        stations = stations,
                        visitedCount = stations.count { it.isVisited },
                        totalCount = stations.size,
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun toggleStation(station: com.katebeavis.tubespotter.domain.model.Station) {
        viewModelScope.launch {
            toggleStationVisited(station)
        }
    }
}