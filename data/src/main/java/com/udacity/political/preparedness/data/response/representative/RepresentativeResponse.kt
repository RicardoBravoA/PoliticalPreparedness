package com.udacity.political.preparedness.data.response.representative

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepresentativeResponse(
    val offices: List<OfficeResponse>,
    val officials: List<Official>
) : Parcelable
