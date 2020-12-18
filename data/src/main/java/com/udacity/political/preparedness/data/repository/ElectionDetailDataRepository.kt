package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.service.ElectionDetailServiceDataStore
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionDetailRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionDetailDataRepository : ElectionDetailRepository {

    override suspend fun get(
        id: String,
        address: String
    ): ResultType<ElectionDetailModel, ErrorModel> {
        return ElectionDetailServiceDataStore().get(id, address)
    }

}