package com.katebeavis.tubespotter.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stations")
data class StationEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val zone: String,
    val isVisited: Boolean = false,
    val visitedAt: Long? = null,
    val photoUri: String? = null,
)
      