package com.udacity.political.preparedness.data.response.detail

import android.os.Parcelable
import com.udacity.political.preparedness.data.response.AddressResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AdministrationBodyResponse(
    val name: String? = null,
    val electionInfoUrl: String? = null,
    val votingLocationFinderUrl: String? = null,
    val ballotInfoUrl: String? = null,
    val correspondenceAddress: AddressResponse? = null
) : Parcelable
