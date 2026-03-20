package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.repository.StationRepository
import javax.inject.Inject

class SaveStationPhotoUseCase @Inject constructor(
    private val repository: StationRepository,
) {
    suspend operator fun invoke(stationId: Int, uri: String) =
        repository.saveStationPhoto(stationId, uri)
}