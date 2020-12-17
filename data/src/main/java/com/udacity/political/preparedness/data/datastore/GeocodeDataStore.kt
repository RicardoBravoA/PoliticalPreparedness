package com.udacity.political.preparedness.data.datastore

import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.GeocodeModel
import com.udacity.political.preparedness.domain.util.ResultType

interface GeocodeDataStore {

    suspend fun get(coordinates: String): ResultType<GeocodeModel, ErrorModel>

}