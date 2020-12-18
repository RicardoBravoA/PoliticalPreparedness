package com.udacity.political.preparedness.data.datastore

import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

interface SavedElectionDetailDataStore {

    suspend fun get(id: String): ResultType<ElectionDetailModel, ErrorModel>

    suspend fun getAll(): ResultType<List<ElectionDetailModel>, ErrorModel>

    suspend fun save(electionDetailModel: ElectionDetailModel)

    suspend fun delete(id: String)

}