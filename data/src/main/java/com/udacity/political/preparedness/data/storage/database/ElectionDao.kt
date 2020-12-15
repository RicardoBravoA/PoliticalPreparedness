package com.udacity.political.preparedness.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.udacity.political.preparedness.data.storage.entity.ElectionEntity

@Dao
interface ElectionDao {

    //TODO: Add insert query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcomingElection(election: ElectionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSaveElection(election: ElectionEntity)

    //TODO: Add select all election query

    //TODO: Add select single election query

    //TODO: Add delete query

    //TODO: Add clear query

}