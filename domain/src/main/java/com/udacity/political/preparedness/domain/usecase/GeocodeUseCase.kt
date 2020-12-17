package com.udacity.political.preparedness.domain.usecase

import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.GeocodeModel
import com.udacity.political.preparedness.domain.repository.GeocodeRepository
import com.udacity.political.preparedness.domain.util.ResultType

class GeocodeUseCase(private val geocodeRepository: GeocodeRepository) {

    suspend fun get(coordinates: String): ResultType<GeocodeModel, ErrorModel> {
        return ResultType.Success(GeocodeModel("1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA"))
//        return geocodeRepository.get(coordinates)
    }

}