package com.udacity.political.preparedness.data.entity

import android.os.Parcelable
import androidx.room.Embedded
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ElectionResponse(
    val id: Int,
    val name: String,
    val electionDay: Date,
    @Embedded(prefix = "division_") @Json(name = "ocdDivisionId") val divisionResponse: DivisionResponse
) : Parcelable