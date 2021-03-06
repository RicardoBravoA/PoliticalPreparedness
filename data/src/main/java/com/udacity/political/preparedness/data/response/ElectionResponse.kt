package com.udacity.political.preparedness.data.response

import android.os.Parcelable
import com.udacity.political.preparedness.data.response.detail.ElectionItemResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ElectionResponse(
    val elections: List<ElectionItemResponse>
) : Parcelable