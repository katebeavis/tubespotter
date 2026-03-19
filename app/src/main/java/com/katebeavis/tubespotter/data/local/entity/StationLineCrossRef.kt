package com.katebeavis.tubespotter.data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "station_line_cross_ref",
    primaryKeys = ["stationId", "lineId"],
)
data class StationLineCrossRef(
    val stationId: Int,
    val lineId: Int,
)