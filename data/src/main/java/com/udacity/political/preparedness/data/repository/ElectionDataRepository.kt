package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.datastore.factory.ElectionDataStoreFactory
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionDataRepository(private val dataStoreFactory: ElectionDataStoreFactory) :
    ElectionRepository {

    override suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> {
        val dataStore = dataStoreFactory.create()
        return dataStore.get()
    }

}