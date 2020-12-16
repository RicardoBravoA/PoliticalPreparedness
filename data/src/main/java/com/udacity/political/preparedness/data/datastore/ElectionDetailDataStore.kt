package com.udacity.political.preparedness.data.datastore

import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

interface ElectionDetailDataStore {

    suspend fun get(): ResultType<List<ElectionDetailModel>, ErrorModel>

}