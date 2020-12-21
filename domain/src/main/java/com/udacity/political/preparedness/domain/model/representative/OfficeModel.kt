package com.udacity.political.preparedness.domain.model.representative

import android.os.Parcelable
import com.udacity.political.preparedness.domain.model.DivisionModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OfficeModel(
    val name: String,
    val division: DivisionModel,
    val officials: List<Int>
) : Parcelable
