package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.repository.StationRepository
import javax.inject.Inject

class ToggleStationVisitedUseCase @Inject constructor(
    private val repository: StationRepository,
) {
    suspend operator fun invoke(station: Station) {
        val updated = station.copy(
            isVisited = !station.isVisited,
            visitedAt = if (!station.isVisited) System.currentTimeMillis() else null,
        )
        repository.toggleStationVisited(updated)
    }
}