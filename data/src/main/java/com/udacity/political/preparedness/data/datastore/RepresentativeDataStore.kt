package com.udacity.political.preparedness.data.datastore

import com.udacity.political.preparedness.data.response.representative.RepresentativeResponse
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

interface RepresentativeDataStore {

    suspend fun get(): ResultType<RepresentativeResponse, ErrorModel>

}