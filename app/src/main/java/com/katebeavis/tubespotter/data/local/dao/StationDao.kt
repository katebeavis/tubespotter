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
}