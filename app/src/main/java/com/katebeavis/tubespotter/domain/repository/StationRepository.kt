package com.katebeavis.tubespotter.domain.repository

import com.katebeavis.tubespotter.domain.model.Line
import com.katebeavis.tubespotter.domain.model.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {
    fun getAllStations(): Flow<List<Station>>
    fun getStationsByLineId(lineId: Int): Flow<List<Station>>
    fun getAllLines(): Flow<List<Line>>
    suspend fun toggleStationVisited(station: Station)
    suspend fun saveStationPhoto(stationId: Int, uri: String)
    suspend fun deleteStationPhoto(stationId: Int, uri: String)

    fun getStationById(stationId: Int): Flow<Station?>
    suspend fun getStationsForLineSync(lineId: Int): List<Station>
    suspend fun getLineIdsForStation(stationId: Int): List<Int>
}