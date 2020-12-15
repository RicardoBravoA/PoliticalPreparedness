package com.udacity.political.preparedness.domain.repository

import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.util.ResultType

interface ElectionRepository {

    suspend fun get(): ResultType<List<ElectionModel>, ErrorModel>

}