package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.repository.StationRepository
import javax.inject.Inject

class DeleteStationPhotoUseCase @Inject constructor(
    private val repository: StationRepository,
) {
    suspend operator fun invoke(stationId: Int, uri: String) =
        repository.deleteStationPhoto(stationId, uri)
}