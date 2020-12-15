package com.udacity.political.preparedness.data.util

import com.udacity.political.preparedness.data.entity.ErrorResponse
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.network.ApiManager
import retrofit2.Response
import java.io.IOException

object RetrofitErrorUtil {
    fun parseError(response: Response<*>): ErrorResponse? {

        val converter = ApiManager.retrofit.responseBodyConverter<ErrorResponse>(
            ErrorResponse::class.java,
            arrayOfNulls<Annotation>(0)
        )

        val error: ErrorResponse

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return ErrorMapper.errorResponseDefault()
        }

        return error
    }
}