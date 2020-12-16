package com.udacity.political.preparedness.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.political.preparedness.data.storage.entity.ElectionDetailEntity

@Dao
interface ElectionDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElectionDetail(detail: ElectionDetailEntity)

    @Query("select * from election_detail_table where id = :id")
    fun getElectionDetail(id: String): ElectionDetailEntity

}