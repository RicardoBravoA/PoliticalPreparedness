package com.udacity.political.preparedness.data.response.representative

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChannelResponse(
    val type: String,
    val id: String
) : Parcelable