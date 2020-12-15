package com.udacity.political.preparedness.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DivisionModel(
    val id: String,
    val country: String,
    val state: String
) : Parcelable