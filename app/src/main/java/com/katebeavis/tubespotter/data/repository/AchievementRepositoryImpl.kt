package com.katebeavis.tubespotter.data.repository

import com.katebeavis.tubespotter.data.local.dao.AchievementDao
import com.katebeavis.tubespotter.data.local.dao.LineDao
import com.katebeavis.tubespotter.data.local.entity.AchievementEntity
import com.katebeavis.tubespotter.domain.model.Achievement
import com.katebeavis.tubespotter.domain.repository.AchievementRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AchievementRepositoryImpl @Inject constructor(
    private val achievementDao: AchievementDao,
    private val lineDao: LineDao,
) : AchievementRepository {

    override fun getAllAchievements(): Flow<List<Achievement>> =
        combine(
            achievementDao.getAllAchievements(),
            lineDao.getAllLines(),
        ) { achievements, lines ->
            val lineMap = lines.associateBy { it.id }
            achievements.map { entity ->
                Achievement(
                    id = entity.id,
                    lineId = entity.lineId,
                    lineName = entity.lineId?.let { lineMap[it]?.name },
                    unlockedAt = entity.unlockedAt,
                )
            }
        }

    override suspend fun unlockAchievement(lineId: Int?) {
        val existing = if (lineId != null) {
            achievementDao.getAchievementByLineId(lineId)
        } else {
            achievementDao.getAllStationsAchievement()
        }
        if (existing == null) {
            achievementDao.insertAchievement(
                AchievementEntity(
                    id = lineId ?: ALL_STATIONS_ACHIEVEMENT_ID,
                    lineId = lineId,
                    unlockedAt = System.currentTimeMillis(),
                )
            )
        }
    }

    companion object {
        const val ALL_STATIONS_ACHIEVEMENT_ID = 0
    }
}