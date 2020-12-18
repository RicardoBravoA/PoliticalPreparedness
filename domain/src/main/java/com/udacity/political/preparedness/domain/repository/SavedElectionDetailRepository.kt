package com.udacity.political.preparedness.domain.repository

import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

interface SavedElectionDetailRepository {

    suspend fun get(id: String, address: String): ResultType<ElectionDetailModel, ErrorModel>

    suspend fun save(electionDetailModel: ElectionDetailModel)

}