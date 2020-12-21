package com.udacity.political.preparedness.data.response.representative

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OfficeResponse(
    val name: String,
    @Json(name = "divisionId") val division: String,
    @Json(name = "officialIndices") val officials: List<Int>
) : Parcelable {
    /*fun getRepresentatives(officials: List<Official>): List<Representative> {
        return this.officials.map { index ->
            Representative(officials[index], this)
        }
    }*/
}
