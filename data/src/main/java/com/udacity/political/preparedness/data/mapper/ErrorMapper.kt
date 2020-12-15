package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.entity.ErrorResponse
import com.udacity.political.preparedness.domain.model.ErrorModel

object ErrorMapper {

    fun transformResponseToModel(errorResponse: ErrorResponse): ErrorModel {
        errorResponse.error.apply {
            return ErrorModel(
                ErrorModel.Error(
                    code,
                    message,
                    status
                )
            )
        }
    }

}