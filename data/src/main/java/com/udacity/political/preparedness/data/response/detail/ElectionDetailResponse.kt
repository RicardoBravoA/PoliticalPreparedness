package com.udacity.political.preparedness.data.response.detail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ElectionDetailResponse(
    val election: ElectionItemResponse,
    val normalizedInput: NormalizedInputResponse?,
    val state: List<StateResponse>
) : Parcelable