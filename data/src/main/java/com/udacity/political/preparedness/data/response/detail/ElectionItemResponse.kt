package com.udacity.political.preparedness.data.response.detail

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ElectionItemResponse(
    val id: String,
    val name: String,
    val electionDay: Date,
    @Json(name = "ocdDivisionId") val divisionId: String
) : Parcelable