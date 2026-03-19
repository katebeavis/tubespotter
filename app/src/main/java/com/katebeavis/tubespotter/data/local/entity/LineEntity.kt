package com.katebeavis.tubespotter.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lines")
data class LineEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val colour: String,
    val displayOrder: Int,
)