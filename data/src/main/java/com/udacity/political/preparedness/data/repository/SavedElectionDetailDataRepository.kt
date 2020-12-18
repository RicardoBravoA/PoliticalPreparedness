package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.storage.SavedElectionDetailStorageDataStore
import com.udacity.political.preparedness.data.storage.database.ElectionDetailDao
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.SavedElectionDetailRepository
import com.udacity.political.preparedness.domain.util.ResultType

class SavedElectionDetailDataRepository(private val electionDetailDao: ElectionDetailDao) :
    SavedElectionDetailRepository {

    override suspend fun get(
        id: String,
        address: String
    ): ResultType<ElectionDetailModel, ErrorModel> {
        return SavedElectionDetailStorageDataStore(electionDetailDao).get(id, address)
    }

    override suspend fun save(electionDetailModel: ElectionDetailModel) {
        return SavedElectionDetailStorageDataStore(electionDetailDao).save(electionDetailModel)
    }

}