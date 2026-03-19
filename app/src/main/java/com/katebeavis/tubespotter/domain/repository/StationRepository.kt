package com.katebeavis.tubespotter.domain.repository

import com.katebeavis.tubespotter.domain.model.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {
    fun getAllStations(): Flow<List<Station>>
    suspend fun toggleStationVisited(station: Station)
}