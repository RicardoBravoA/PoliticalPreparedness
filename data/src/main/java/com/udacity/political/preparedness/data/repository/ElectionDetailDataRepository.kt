package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.datastore.ElectionDataStoreFactory
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionDetailRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionDetailDataRepository(private val dataStoreFactory: ElectionDataStoreFactory) :
    ElectionDetailRepository {

    override suspend fun get(id: String): ResultType<ElectionDetailModel, ErrorModel> {
        val dataStore = dataStoreFactory.create()
        return dataStore.get()
    }

}