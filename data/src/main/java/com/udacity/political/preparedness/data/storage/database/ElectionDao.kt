package com.udacity.political.preparedness.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.udacity.political.preparedness.network.models.Election

@Dao
interface ElectionDao {

    //TODO: Add insert query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcomingElection(election: Election)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSaveElection(election: Election)

    //TODO: Add select all election query

    //TODO: Add select single election query

    //TODO: Add delete query

    //TODO: Add clear query

}