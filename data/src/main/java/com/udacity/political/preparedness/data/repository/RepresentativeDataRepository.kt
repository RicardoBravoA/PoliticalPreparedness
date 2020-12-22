package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.data.service.RepresentativeServiceDataStore
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.domain.repository.RepresentativeRepository
import com.udacity.political.preparedness.domain.util.ResultType

class RepresentativeDataRepository : RepresentativeRepository {

    override suspend fun get(address: String): ResultType<List<RepresentativeModel>, ErrorModel> {
        return RepresentativeServiceDataStore().get(address)
    }

}