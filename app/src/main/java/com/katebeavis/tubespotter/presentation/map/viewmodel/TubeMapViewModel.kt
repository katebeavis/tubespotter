package com.katebeavis.tubespotter.presentation.map.viewmodel

import androidx.lifecycle.viewModelScope
import com.katebeavis.tubespotter.domain.usecase.GetMapDataUseCase
import com.katebeavis.tubespotter.presentation.common.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TubeMapViewModel @Inject constructor(
    private val getMapData: GetMapDataUseCase,
) : BaseViewModel<TubeMapUiState, TubeMapUiAction, TubeMapUiSideEffect>(
    TubeMapUiState()
) {
    init {
        observeStations()
    }

    private fun observeStations() {
        getMapData()
            .onEach { stations -> updateState { copy(stations = stations) } }
            .launchIn(viewModelScope)
    }

    override fun handleAction(action: TubeMapUiAction) {
        when (action) {
            is TubeMapUiAction.StationTapped -> viewModelScope.launch {
                postSideEffect(TubeMapUiSideEffect.NavigateToDetail(action.stationId))
            }
        }
    }
}