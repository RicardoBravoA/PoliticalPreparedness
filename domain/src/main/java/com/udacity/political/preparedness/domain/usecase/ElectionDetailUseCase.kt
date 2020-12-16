package com.udacity.political.preparedness.domain.usecase

import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionDetailRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionDetailUseCase(private val electionRepository: ElectionDetailRepository) {

    suspend fun get(): ResultType<List<ElectionDetailModel>, ErrorModel> {
        return electionRepository.get()
    }

}