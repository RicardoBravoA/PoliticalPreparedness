package com.udacity.political.preparedness.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.political.preparedness.data.storage.entity.SavedElectionDetailEntity

@Dao
interface SavedElectionDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElectionDetail(detailSaved: SavedElectionDetailEntity)

    @Query("select * from election_detail_table where id = :id")
    fun getElectionDetail(id: String): SavedElectionDetailEntity

    @Query("select * from election_detail_table ")
    fun getAllElectionDetail(): List<SavedElectionDetailEntity>

}