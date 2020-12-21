package com.udacity.political.preparedness.domain.model.representative

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChannelModel(
    val type: String,
    val id: String
) : Parcelable