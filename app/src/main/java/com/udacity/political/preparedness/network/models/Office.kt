package com.udacity.political.preparedness.network.models

/*
import android.os.Parcelable
import com.squareup.moshi.Json
import com.udacity.political.preparedness.data.storage.entity.DivisionEntity
import com.udacity.political.preparedness.representative.model.Representative
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Office(
    val name: String,
    @Json(name = "divisionId") val divisionEntity: DivisionEntity,
    @Json(name = "officialIndices") val officials: List<Int>
) : Parcelable {
    fun getRepresentatives(officials: List<Official>): List<Representative> {
        return this.officials.map { index ->
            Representative(officials[index], this)
        }
    }
}*/
