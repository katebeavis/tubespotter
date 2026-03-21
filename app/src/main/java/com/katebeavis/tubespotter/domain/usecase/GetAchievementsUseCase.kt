package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Achievement
import com.katebeavis.tubespotter.domain.repository.AchievementRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAchievementsUseCase @Inject constructor(
    private val repository: AchievementRepository,
) {
    operator fun invoke(): Flow<List<Achievement>> = repository.getAllAchievements()
}