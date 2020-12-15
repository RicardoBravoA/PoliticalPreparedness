package com.udacity.political.preparedness.data.datastore

import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

interface ElectionDataStore {

    suspend fun get(): ResultType<List<ElectionModel>, ErrorModel>

}