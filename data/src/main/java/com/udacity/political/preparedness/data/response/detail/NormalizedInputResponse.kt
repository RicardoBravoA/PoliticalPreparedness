package com.udacity.political.preparedness.data.response.detail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NormalizedInputResponse(
    val line1: String,
    val city: String,
    val state: String,
    val zip: String
) : Parcelable