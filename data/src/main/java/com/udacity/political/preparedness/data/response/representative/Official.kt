package com.udacity.political.preparedness.data.response.representative

import android.os.Parcelable
import com.udacity.political.preparedness.data.response.AddressResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Official(
    val name: String,
    val address: List<AddressResponse>? = null,
    val party: String? = null,
    val phones: List<String>? = null,
    val urls: List<String>? = null,
    val photoUrl: String? = null,
    val channels: List<ChannelResponse>? = null
) : Parcelable