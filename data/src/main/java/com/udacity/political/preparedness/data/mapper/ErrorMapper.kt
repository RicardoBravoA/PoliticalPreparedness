package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.entity.ErrorResponse
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ConstantError

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

    fun errorModelDefault(): ErrorModel {
        return ErrorModel(
            ErrorModel.Error(
                100, ConstantError.ERROR, "PERMISSION_DENIED"
            )
        )
    }

    fun errorResponseDefault(): ErrorResponse {
        return ErrorResponse(
            ErrorResponse.Error(
                100, ConstantError.ERROR, "PERMISSION_DENIED"
            )
        )
    }

}