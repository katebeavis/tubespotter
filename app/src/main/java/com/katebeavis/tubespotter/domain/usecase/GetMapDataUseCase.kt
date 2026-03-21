package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.model.StationCoordinate
import com.katebeavis.tubespotter.domain.repository.StationRepository
import com.katebeavis.tubespotter.data.local.seed.StationCoordinates
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

data class MapStation(
    val station: Station,
    val coordinate: StationCoordinate,
)

class GetMapDataUseCase @Inject constructor(
    private val repository: StationRepository,
) {
    operator fun invoke(): Flow<List<MapStation>> =
        repository.getAllStations().map { stations ->
            stations.mapNotNull { station ->
                val coord = StationCoordinates.coordinates[station.id] ?: return@mapNotNull null
                MapStation(
                    station = station,
                    coordinate = StationCoordinate(station.id, coord.first, coord.second),
                )
            }
        }
}