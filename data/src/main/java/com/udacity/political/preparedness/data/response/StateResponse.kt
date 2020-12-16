package com.udacity.political.preparedness.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StateResponse(
    val name: String,
    val electionAdministrationBody: AdministrationBodyResponse
) : Parcelable
