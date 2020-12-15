package com.udacity.political.preparedness.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorModel(
    val error: Error
) : Parcelable {

    @Parcelize
    data class Error(
        val code: Int,
        val message: String,
        val status: String
    ) : Parcelable

}