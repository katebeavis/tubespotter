package com.katebeavis.tubespotter.presentation.achievements.viewmodel

import com.katebeavis.tubespotter.domain.model.Achievement
import com.katebeavis.tubespotter.presentation.common.mvi.UiState

data class AchievementsUiState(
    val achievements: List<Achievement> = emptyList(),
) : UiState