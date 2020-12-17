package com.udacity.political.preparedness.domain.repository

import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

interface ElectionDetailRepository {

    suspend fun get(id: String, address: String): ResultType<ElectionDetailModel, ErrorModel>

}