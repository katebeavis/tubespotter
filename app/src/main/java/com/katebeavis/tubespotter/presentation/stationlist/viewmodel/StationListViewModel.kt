package com.katebeavis.tubespotter.presentation.stationlist.viewmodel

import androidx.lifecycle.viewModelScope
import com.katebeavis.tubespotter.data.local.photo.PhotoStorage
import com.katebeavis.tubespotter.domain.usecase.DeleteStationPhotoUseCase
import com.katebeavis.tubespotter.domain.usecase.GetAllLinesUseCase
import com.katebeavis.tubespotter.domain.usecase.GetAllStationsUseCase
import com.katebeavis.tubespotter.domain.usecase.GetStationsByLineUseCase
import com.katebeavis.tubespotter.domain.usecase.SaveStationPhotoUseCase
import com.katebeavis.tubespotter.domain.usecase.ToggleStationVisitedUseCase
import com.katebeavis.tubespotter.presentation.common.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationListViewModel @Inject constructor(
    private val getAllStations: GetAllStationsUseCase,
    private val getStationsByLine: GetStationsByLineUseCase,
    private val getAllLines: GetAllLinesUseCase,
    private val toggleStationVisited: ToggleStationVisitedUseCase,
    private val saveStationPhoto: SaveStationPhotoUseCase,
    private val deleteStationPhoto: DeleteStationPhotoUseCase,
    private val photoStorage: PhotoStorage,
) : BaseViewModel<StationListUiState, StationListUiAction, StationListUiSideEffect>(
    initialState = StationListUiState()
) {

    init {
        observeLines()
        observeStations()
    }

    override fun handleAction(action: StationListUiAction) {
        when (action) {
            is StationListUiAction.ToggleStation -> toggleStation(action.station)
            is StationListUiAction.SelectLine -> selectLine(action.lineId)
            is StationListUiAction.ClearFilter -> clearFilter()
            is StationListUiAction.TakePhoto -> takePhoto(action.stationId)
            is StationListUiAction.PhotoCaptured -> onPhotoCaptured(action.stationId, action.uri)
            is StationListUiAction.DeletePhoto -> onDeletePhoto(action.stationId, action.uri)
            is StationListUiAction.DeletePhotoConfirmed -> onDeletePhotoConfirmed(action.stationId, action.uri)
            is StationListUiAction.StorePendingPhoto -> updateState {
                copy(pendingPhotoStationId = action.stationId, pendingPhotoUri = action.uri)
            }
        }
    }

    private fun observeLines() {
        getAllLines()
            .onEach { lines -> updateState { copy(lines = lines) } }
            .launchIn(viewModelScope)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeStations() {
        uiState
            .flatMapLatest { state ->
                val lineId = state.selectedLineId
                if (lineId == null) getAllStations() else getStationsByLine(lineId)
            }
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

    private fun selectLine(lineId: Int) {
        updateState { copy(selectedLineId = lineId) }
    }

    private fun clearFilter() {
        updateState { copy(selectedLineId = null) }
    }

    private fun takePhoto(stationId: Int) {
        viewModelScope.launch {
            val file = photoStorage.createImageFile()
            val uri = photoStorage.getUriForFile(file).toString()
            postSideEffect(StationListUiSideEffect.LaunchCamera(stationId, uri))
        }
    }

    private fun onPhotoCaptured(stationId: Int, uri: String) {
        viewModelScope.launch { saveStationPhoto(stationId, uri) }
    }

    private fun onDeletePhoto(stationId: Int, uri: String) {
        viewModelScope.launch {
            postSideEffect(StationListUiSideEffect.ShowDeleteConfirmation(stationId, uri))
        }
    }

    private fun onDeletePhotoConfirmed(stationId: Int, uri: String) {
        viewModelScope.launch { deleteStationPhoto(stationId, uri) }
    }
}