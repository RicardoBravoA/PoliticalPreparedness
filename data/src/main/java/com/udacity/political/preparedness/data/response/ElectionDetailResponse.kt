package com.udacity.political.preparedness.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ElectionDetailResponse(
    val election: ElectionItemResponse,
    val state: List<StateResponse>
) : Parcelable