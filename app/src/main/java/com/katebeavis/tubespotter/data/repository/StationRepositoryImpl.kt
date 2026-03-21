package com.katebeavis.tubespotter.data.repository

import com.katebeavis.tubespotter.data.local.dao.LineDao
import com.katebeavis.tubespotter.data.local.dao.StationDao
import com.katebeavis.tubespotter.data.local.entity.LineEntity
import com.katebeavis.tubespotter.data.local.entity.StationEntity
import com.katebeavis.tubespotter.data.local.photo.PhotoStorage
import com.katebeavis.tubespotter.domain.model.Line
import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StationRepositoryImpl @Inject constructor(
    private val stationDao: StationDao,
    private val lineDao: LineDao,
    private val photoStorage: PhotoStorage,
) : StationRepository {

    override fun getAllStations(): Flow<List<Station>> =
        stationDao.getAllStations().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun toggleStationVisited(station: Station) {
        stationDao.updateStation(station.toEntity())
    }

    override fun getStationsByLineId(lineId: Int): Flow<List<Station>> =
        stationDao.getStationsByLineId(lineId).map { entities ->
            entities.map { it.toDomain() }
        }

    override fun getAllLines(): Flow<List<Line>> =
        lineDao.getAllLines().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun saveStationPhoto(stationId: Int, uri: String) {
        stationDao.updatePhotoUri(stationId, uri)
    }

    override suspend fun deleteStationPhoto(stationId: Int, uri: String) {
        photoStorage.deletePhoto(uri)
        stationDao.clearPhotoUri(stationId)
    }

    override fun getStationById(stationId: Int): Flow<Station?> =
        stationDao.getStationById(stationId).map { it?.toDomain() }

    private fun StationEntity.toDomain() = Station(
        id = id,
        name = name,
        zone = zone,
        isVisited = isVisited,
        visitedAt = visitedAt,
        photoUri = photoUri,
    )

    private fun Station.toEntity() = StationEntity(
        id = id,
        name = name,
        zone = zone,
        isVisited = isVisited,
        visitedAt = visitedAt,
    )

    private fun LineEntity.toDomain() = Line(
        id = id,
        name = name,
        colour = colour,
        displayOrder = displayOrder,
    )
}