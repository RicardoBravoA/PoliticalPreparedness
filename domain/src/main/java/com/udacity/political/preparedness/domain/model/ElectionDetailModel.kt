package com.udacity.political.preparedness.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ElectionDetailModel(
    val id: String,
    val name: String,
    val electionDay: Date,
    val divisionModel: DivisionModel,
    val electionInfoUrl: String?,
    val votingLocationFinderUrl: String?,
    val ballotInfoUrl: String?,
    val address: String?
) : Parcelable