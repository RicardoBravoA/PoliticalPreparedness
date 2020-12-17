package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.datastore.factory.GeocodeDataStoreFactory
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.GeocodeModel
import com.udacity.political.preparedness.domain.repository.GeocodeRepository
import com.udacity.political.preparedness.domain.util.ResultType

class GeocodeDataRepository(private val dataStoreFactory: GeocodeDataStoreFactory) :
    GeocodeRepository {

    override suspend fun get(coordinates: String): ResultType<GeocodeModel, ErrorModel> {
        val dataStore = dataStoreFactory.create()
        return dataStore.get(coordinates)
    }

}