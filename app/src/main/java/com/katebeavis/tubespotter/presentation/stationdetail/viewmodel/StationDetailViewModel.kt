package com.katebeavis.tubespotter.presentation.stationdetail.viewmodel

import androidx.lifecycle.viewModelScope
import com.katebeavis.tubespotter.domain.usecase.GetStationDetailUseCase
import com.katebeavis.tubespotter.domain.usecase.ToggleStationVisitedUseCase
import com.katebeavis.tubespotter.presentation.common.mvi.BaseViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = StationDetailViewModel.Factory::class)
class StationDetailViewModel @AssistedInject constructor(
    @Assisted private val stationId: Int,
    private val getStationDetail: GetStationDetailUseCase,
    private val toggleStationVisited: ToggleStationVisitedUseCase,
) : BaseViewModel<StationDetailUiState, StationDetailUiAction, StationDetailUiSideEffect>(
    StationDetailUiState.Loading
) {
    @AssistedFactory
    interface Factory {
        fun create(stationId: Int): StationDetailViewModel
    }

    init {
        observeStation()
    }

    private fun observeStation() {
        getStationDetail(stationId)
            .onEach { station ->
                if (station != null) {
                    updateState { StationDetailUiState.Content(station) }
                }
            }
            .launchIn(viewModelScope)
    }

    override fun handleAction(action: StationDetailUiAction) {
        when (action) {
            StationDetailUiAction.ToggleVisited -> toggleVisited()
            StationDetailUiAction.NavigateBack -> viewModelScope.launch {
                postSideEffect(StationDetailUiSideEffect.GoBack)
            }
        }
    }

    private fun toggleVisited() {
        val content = uiState.value as? StationDetailUiState.Content ?: return
        viewModelScope.launch {
            toggleStationVisited(content.station)
        }
    }
}