package com.udacity.political.preparedness.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorResponse(
    val error: Error
) : Parcelable {

    @Parcelize
    data class Error(
        val code: Int,
        val message: String,
        val status: String
    ) : Parcelable

}