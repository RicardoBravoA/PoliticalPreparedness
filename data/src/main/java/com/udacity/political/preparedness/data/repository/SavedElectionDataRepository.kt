package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.datastore.SavedElectionDataStoreFactory
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.SavedElectionRepository
import com.udacity.political.preparedness.domain.util.ResultType

class SavedElectionDataRepository(private val dataStoreFactory: SavedElectionDataStoreFactory) :
    SavedElectionRepository {

    override suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> {
        val dataStore = dataStoreFactory.create()
        return dataStore.get()
    }

}