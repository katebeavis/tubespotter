package com.katebeavis.tubespotter.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.katebeavis.tubespotter.data.local.entity.AchievementEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AchievementDao {
    @Query("SELECT * FROM achievements")
    fun getAllAchievements(): Flow<List<AchievementEntity>>

    @Query("SELECT * FROM achievements WHERE lineId = :lineId")
    suspend fun getAchievementByLineId(lineId: Int): AchievementEntity?

    @Query("SELECT * FROM achievements WHERE lineId IS NULL LIMIT 1")
    suspend fun getAllStationsAchievement(): AchievementEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAchievement(achievement: AchievementEntity)
}