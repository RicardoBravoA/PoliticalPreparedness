package com.udacity.political.preparedness.data.datastore

import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.domain.util.ResultType

interface RepresentativeDataStore {

    suspend fun get(address: String): ResultType<RepresentativeModel, ErrorModel>

}