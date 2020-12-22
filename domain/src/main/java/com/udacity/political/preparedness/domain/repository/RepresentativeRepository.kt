package com.udacity.political.preparedness.domain.repository

import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.domain.util.ResultType

interface RepresentativeRepository {

    suspend fun get(address: String): ResultType<List<RepresentativeModel>, ErrorModel>

}