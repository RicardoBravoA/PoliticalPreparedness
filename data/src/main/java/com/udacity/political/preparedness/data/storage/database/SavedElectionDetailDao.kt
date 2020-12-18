package com.udacity.political.preparedness.data.storage.database

import androidx.room.*
import com.udacity.political.preparedness.data.storage.entity.SavedElectionDetailEntity

@Dao
interface SavedElectionDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElectionDetail(detail: SavedElectionDetailEntity)

    @Query("select * from election_detail_table where id = :id")
    fun getElectionDetail(id: String): SavedElectionDetailEntity

    @Query("select * from election_detail_table")
    fun getAllElectionDetail(): List<SavedElectionDetailEntity>

    @Query("delete from election_detail_table where id = :id")
    fun delete(id: String)

}