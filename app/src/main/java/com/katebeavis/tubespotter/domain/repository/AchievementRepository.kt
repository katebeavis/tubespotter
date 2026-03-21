package com.katebeavis.tubespotter.domain.repository

import com.katebeavis.tubespotter.domain.model.Achievement
import kotlinx.coroutines.flow.Flow

interface AchievementRepository {
    fun getAllAchievements(): Flow<List<Achievement>>
    suspend fun unlockAchievement(lineId: Int?)
}