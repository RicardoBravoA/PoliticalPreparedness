package com.udacity.political.preparedness.data.entity

import android.os.Parcelable
import com.udacity.political.preparedness.domain.util.ConstantError
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorResponse(
    val error: Error = ErrorResponse.Error(100, ConstantError.ERROR, "PERMISSION_DENIED")
) : Parcelable {

    @Parcelize
    data class Error(
        val code: Int,
        val message: String,
        val status: String
    ) : Parcelable

}