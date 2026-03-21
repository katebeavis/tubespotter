package com.katebeavis.tubespotter.di

import android.content.Context
import androidx.room.Room
import com.katebeavis.tubespotter.data.local.dao.AchievementDao
import com.katebeavis.tubespotter.data.local.dao.LineDao
import com.katebeavis.tubespotter.data.local.dao.StationDao
import com.katebeavis.tubespotter.data.local.db.TubeSpotterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TubeSpotterDatabase =
        Room.databaseBuilder(
            context,
            TubeSpotterDatabase::class.java,
            "tubespotter.db",
        )
            .addCallback(TubeSpotterDatabase.seedCallback())
            .addMigrations(TubeSpotterDatabase.MIGRATION_1_2)
            .build()

    @Provides
    fun provideStationDao(database: TubeSpotterDatabase): StationDao = database.stationDao()

    @Provides
    fun provideLineDao(database: TubeSpotterDatabase): LineDao = database.lineDao()

    @Provides
    fun provideAchievementDao(database: TubeSpotterDatabase): AchievementDao = database.achievementDao()
}