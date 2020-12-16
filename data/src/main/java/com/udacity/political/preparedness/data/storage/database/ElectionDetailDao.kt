package com.udacity.political.preparedness.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.political.preparedness.data.storage.entity.SavedElectionEntity

@Dao
interface ElectionDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElectionDetail(election: SavedElectionEntity)

    @Query("select * from saved_election_table")
    fun getSavedElections(): List<SavedElectionEntity>

}