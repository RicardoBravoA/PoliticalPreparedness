package com.udacity.political.preparedness.domain.usecase

import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.SavedElectionDetailRepository
import com.udacity.political.preparedness.domain.util.ResultType

class SavedElectionDetailUseCase(private val savedElectionDetailRepository: SavedElectionDetailRepository) {

    suspend fun get(id: String, address: String): ResultType<ElectionDetailModel, ErrorModel> {
        return savedElectionDetailRepository.get(id, address)
    }

    suspend fun getAll(): ResultType<List<ElectionDetailModel>, ErrorModel> {
        return savedElectionDetailRepository.getAll()
    }

    suspend fun save(electionDetailModel: ElectionDetailModel) {
        return savedElectionDetailRepository.save(electionDetailModel)
    }

}