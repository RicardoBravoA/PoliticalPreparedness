package com.udacity.political.preparedness.data.response.geocode

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultResponse(
    @Json(name = "formatted_address")
    val address: String
) : Parcelable