package com.udacity.political.preparedness.domain.model.representative

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OfficialModel(
    val name: String,
    val address: List<AddressModel>? = null,
    val party: String? = null,
    val phones: List<String>? = null,
    val urls: List<String>? = null,
    val photoUrl: String? = null,
    val channels: List<ChannelModel>? = null
) : Parcelable