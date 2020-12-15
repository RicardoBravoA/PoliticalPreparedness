package com.udacity.political.preparedness.domain.usecase

import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionOfflineUseCase(private val electionRepository: ElectionRepository) {

    suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> {
        return electionRepository.get()
    }

}