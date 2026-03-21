package com.katebeavis.tubespotter.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "achievements")
data class AchievementEntity(
    @PrimaryKey val id: Int,
    val lineId: Int?,
    val unlockedAt: Long?,
)