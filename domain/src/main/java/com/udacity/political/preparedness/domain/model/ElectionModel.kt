package com.udacity.political.preparedness.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ElectionModel(
    val name: String,
    val electionDay: Date,
    val divisionModel: DivisionModel
) : Parcelable