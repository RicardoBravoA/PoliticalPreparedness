package com.udacity.political.preparedness.domain.repository

import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.GeocodeModel
import com.udacity.political.preparedness.domain.util.ResultType

interface GeocodeRepository {

    suspend fun get(coordinates: String): ResultType<GeocodeModel, ErrorModel>

}