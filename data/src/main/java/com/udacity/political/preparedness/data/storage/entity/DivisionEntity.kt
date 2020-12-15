package com.udacity.political.preparedness.data.storage.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DivisionEntity(
    val id: String,
    val country: String,
    val state: String
) : Parcelable