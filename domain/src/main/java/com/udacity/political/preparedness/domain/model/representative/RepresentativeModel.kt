package com.udacity.political.preparedness.domain.model.representative

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepresentativeModel(
    val id: Int,
    val image: String?,
    val title: String?,
    val name: String?,
    val party: String?,
    val web: String?,
    val facebook: String?,
    val twitter: String?
) : Parcelable