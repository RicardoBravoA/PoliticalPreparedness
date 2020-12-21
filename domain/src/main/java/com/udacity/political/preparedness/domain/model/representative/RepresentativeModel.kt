package com.udacity.political.preparedness.domain.model.representative

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepresentativeModel(
    val offices: List<OfficeModel>,
    val officials: List<OfficialModel>
) : Parcelable