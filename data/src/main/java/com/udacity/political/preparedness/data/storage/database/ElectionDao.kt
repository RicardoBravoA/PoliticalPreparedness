package com.udacity.political.preparedness.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.political.preparedness.data.storage.entity.ElectionEntity

@Dao
interface ElectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcomingElection(election: ElectionEntity)

    @Query("select * from election_table")
    fun getElections(): List<ElectionEntity>

}