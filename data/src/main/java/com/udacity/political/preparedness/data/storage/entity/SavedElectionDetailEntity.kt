package com.udacity.political.preparedness.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.util.*

@Entity(tableName = "election_detail_table")
data class SavedElectionDetailEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "electionDay") val electionDay: Date,
    @Json(name = "ocdDivisionId") val divisionId: String,
    @Json(name = "electionInfoUrl") val electionInfoUrl: String?,
    @Json(name = "votingLocationFinderUrl") val votingLocationFinderUrl: String?,
    @Json(name = "ballotInfoUrl") val ballotInfoUrl: String?,
    @Json(name = "address") val address: String?
)