package com.katebeavis.tubespotter.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.katebeavis.tubespotter.data.local.entity.LineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LineDao {

    @Query("SELECT * FROM lines ORDER BY displayOrder ASC")
    fun getAllLines(): Flow<List<LineEntity>>
}