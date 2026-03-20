package com.katebeavis.tubespotter.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.katebeavis.tubespotter.data.local.entity.StationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {

    @Query("SELECT * FROM stations ORDER BY name ASC")
    fun getAllStations(): Flow<List<StationEntity>>

    @Update
    suspend fun updateStation(station: StationEntity)

    @Query("""
      SELECT stations.* FROM stations
      INNER JOIN station_line_cross_ref ON stations.id = station_line_cross_ref.stationId
      WHERE station_line_cross_ref.lineId = :lineId
      ORDER BY stations.name ASC
  """)
    fun getStationsByLineId(lineId: Int): Flow<List<StationEntity>>

    @Query("UPDATE stations SET photoUri = :uri WHERE id = :stationId")
    suspend fun updatePhotoUri(stationId: Int, uri: String)

    @Query("UPDATE stations SET photoUri = NULL WHERE id = :stationId")
    suspend fun clearPhotoUri(stationId: Int)
}