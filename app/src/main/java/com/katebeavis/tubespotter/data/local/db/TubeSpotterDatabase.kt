package com.katebeavis.tubespotter.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.katebeavis.tubespotter.data.local.dao.AchievementDao
import com.katebeavis.tubespotter.data.local.dao.LineDao
import com.katebeavis.tubespotter.data.local.dao.StationDao
import com.katebeavis.tubespotter.data.local.entity.LineEntity
import com.katebeavis.tubespotter.data.local.entity.StationEntity
import com.katebeavis.tubespotter.data.local.entity.StationLineCrossRef
import com.katebeavis.tubespotter.data.local.entity.AchievementEntity
import com.katebeavis.tubespotter.data.local.seed.StationSeedData

@Database(
    entities = [StationEntity::class, LineEntity::class, StationLineCrossRef::class, AchievementEntity::class],
    version = 2,
    exportSchema = false,
)
abstract class TubeSpotterDatabase : RoomDatabase() {
    abstract fun stationDao(): StationDao
    abstract fun lineDao(): LineDao
    abstract fun achievementDao(): AchievementDao

    companion object {
        fun seedCallback() = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                StationSeedData.lines.forEach { line ->
                    db.execSQL(
                        "INSERT INTO lines (id, name, colour, displayOrder) VALUES (?, ?, ?, ?)",
                        arrayOf(line.id, line.name, line.colour, line.displayOrder)
                    )
                }
                StationSeedData.stations.forEach { station ->
                    db.execSQL(
                        "INSERT INTO stations (id, name, zone, isVisited, visitedAt, photoUri) VALUES (?, ?, ?, ?, ?, ?)",
                        arrayOf(station.id, station.name, station.zone, 0, null, null)
                    )
                }
                StationSeedData.crossRefs.forEach { ref ->
                    db.execSQL(
                        "INSERT INTO station_line_cross_ref (stationId, lineId) VALUES (?, ?)",
                        arrayOf(ref.stationId, ref.lineId)
                    )
                }
            }
        }
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS achievements (id INTEGER NOT NULL, lineId INTEGER, unlockedAt INTEGER, PRIMARY KEY(id))"
                )
            }
        }
    }
}