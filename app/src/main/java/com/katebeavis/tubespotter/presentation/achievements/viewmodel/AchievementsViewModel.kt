package com.katebeavis.tubespotter.presentation.achievements.viewmodel

import androidx.lifecycle.viewModelScope
import com.katebeavis.tubespotter.domain.usecase.GetAchievementsUseCase
import com.katebeavis.tubespotter.presentation.common.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val getAchievements: GetAchievementsUseCase,
) : BaseViewModel<AchievementsUiState, AchievementsUiAction, AchievementsUiSideEffect>(
    AchievementsUiState()
) {
    init {
        observeAchievements()
    }

    private fun observeAchievements() {
        getAchievements()
            .onEach { achievements -> updateState { copy(achievements = achievements) } }
            .launchIn(viewModelScope)
    }

    override fun handleAction(action: AchievementsUiAction) = Unit
}