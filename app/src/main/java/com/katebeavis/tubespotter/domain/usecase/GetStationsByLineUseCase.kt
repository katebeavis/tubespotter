package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStationsByLineUseCase @Inject constructor(
    private val repository: StationRepository,
) {
    operator fun invoke(lineId: Int): Flow<List<Station>> =
        repository.getStationsByLineId(lineId)
}