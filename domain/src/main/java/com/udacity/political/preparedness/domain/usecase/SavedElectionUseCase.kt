package com.udacity.political.preparedness.domain.usecase

import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.SavedElectionRepository
import com.udacity.political.preparedness.domain.util.ResultType

class SavedElectionUseCase(private val savedElectionRepository: SavedElectionRepository) {

    suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> {
        return savedElectionRepository.get()
    }

}