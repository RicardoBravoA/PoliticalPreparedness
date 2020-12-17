package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.datastore.factory.ElectionDetailDataStoreFactory
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionDetailRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionDetailDataRepository(private val dataStoreFactory: ElectionDetailDataStoreFactory) :
    ElectionDetailRepository {

    override suspend fun get(
        id: String,
        address: String
    ): ResultType<ElectionDetailModel, ErrorModel> {
        val dataStore = dataStoreFactory.create()
        return dataStore.get(id, address)
    }

}