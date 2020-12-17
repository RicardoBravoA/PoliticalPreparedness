package com.udacity.political.preparedness.domain.usecase

import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.GeocodeModel
import com.udacity.political.preparedness.domain.repository.GeocodeRepository
import com.udacity.political.preparedness.domain.util.ResultType

class GeocodeUseCase(private val geocodeRepository: GeocodeRepository) {

    suspend fun get(coordinates: String): ResultType<GeocodeModel, ErrorModel> {
        return geocodeRepository.get(coordinates)
    }

}