package com.udacity.political.preparedness.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ElectionResponse(
    val elections: List<ElectionItemResponse>
) : Parcelable