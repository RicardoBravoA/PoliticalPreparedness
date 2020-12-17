package com.udacity.political.preparedness.data.datastore

import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

interface ElectionDetailDataStore {

    suspend fun get(id: String, address: String): ResultType<ElectionDetailModel, ErrorModel>

}