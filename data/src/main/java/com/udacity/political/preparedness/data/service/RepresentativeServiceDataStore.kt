package com.udacity.political.preparedness.data.service

import com.udacity.political.preparedness.data.datastore.RepresentativeDataStore
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.mapper.RepresentativeMapper
import com.udacity.political.preparedness.data.network.ApiManager
import com.udacity.political.preparedness.data.util.RetrofitErrorUtil
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.domain.util.ResultType

class RepresentativeServiceDataStore() : RepresentativeDataStore {

    override suspend fun get(address: String): ResultType<List<RepresentativeModel>, ErrorModel> {
        val response = ApiManager.get().representatives(address)
        return if (response.isSuccessful) {
            val response = response.body()
            ResultType.Success(RepresentativeMapper.transformResponseToModel(response!!))
        } else {
            val error = RetrofitErrorUtil.parseError(response)!!
            ResultType.Error(ErrorMapper.transformResponseToModel(error))
        }
    }


}