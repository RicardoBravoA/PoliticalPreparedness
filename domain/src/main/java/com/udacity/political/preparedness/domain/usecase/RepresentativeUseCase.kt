package com.udacity.political.preparedness.domain.usecase

import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.domain.repository.RepresentativeRepository
import com.udacity.political.preparedness.domain.util.ResultType

class RepresentativeUseCase(private val representativeRepository: RepresentativeRepository) {

    suspend fun get(address: String): ResultType<RepresentativeModel, ErrorModel> {
        return representativeRepository.get(address)
    }

}