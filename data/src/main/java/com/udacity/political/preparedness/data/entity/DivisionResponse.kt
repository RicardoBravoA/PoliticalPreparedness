package com.udacity.political.preparedness.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DivisionResponse(
    val id: String,
    val country: String,
    val state: String
) : Parcelable