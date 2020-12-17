package com.udacity.political.preparedness.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeocodeModel(val address: String) : Parcelable