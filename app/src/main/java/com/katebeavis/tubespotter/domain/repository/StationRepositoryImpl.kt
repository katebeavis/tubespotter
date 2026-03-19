package com.katebeavis.tubespotter.data.repository

import com.katebeavis.tubespotter.data.local.dao.StationDao
import com.katebeavis.tubespotter.data.local.entity.StationEntity
import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StationRepositoryImpl @Inject constructor(
    private val stationDao: StationDao,
) : StationRepository {

    override fun getAllStations(): Flow<List<Station>> =
        stationDao.getAllStations().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun toggleStationVisited(station: Station) {
        stationDao.updateStation(station.toEntity())
    }

    private fun StationEntity.toDomain() = Station(
        id = id,
        name = name,
        zone = zone,
        isVisited = isVisited,
        visitedAt = visitedAt,
    )

    private fun Station.toEntity() = StationEntity(
        id = id,
        name = name,
        zone = zone,
        isVisited = isVisited,
        visitedAt = visitedAt,
    )
}