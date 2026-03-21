package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.repository.AchievementRepository
import com.katebeavis.tubespotter.domain.repository.StationRepository
import javax.inject.Inject

class CheckLineCompletionUseCase @Inject constructor(
    private val stationRepository: StationRepository,
    private val achievementRepository: AchievementRepository,
) {
    suspend operator fun invoke(stationId: Int) {
        val lineIds = stationRepository.getLineIdsForStation(stationId)
        lineIds.forEach { lineId ->
            val stations = stationRepository.getStationsForLineSync(lineId)
            if (stations.isNotEmpty() && stations.all { it.isVisited }) {
                achievementRepository.unlockAchievement(lineId)
            }
        }
    }
}