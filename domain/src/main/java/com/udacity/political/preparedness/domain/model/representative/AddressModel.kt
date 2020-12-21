package com.udacity.political.preparedness.domain.model.representative

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressModel(
    val line1: String,
    val line2: String? = null,
    val city: String,
    val state: String,
    val zip: String
) : Parcelable