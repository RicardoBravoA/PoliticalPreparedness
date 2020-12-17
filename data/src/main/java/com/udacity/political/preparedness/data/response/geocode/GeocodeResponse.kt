package com.udacity.political.preparedness.data.response.geocode

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeocodeResponse(
    val status: String,
    val results: ResultResponse
) : Parcelable