package com.udacity.political.preparedness.data.service

import com.udacity.political.preparedness.data.datastore.ElectionDetailDataStore
import com.udacity.political.preparedness.data.mapper.ElectionDetailMapper
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.network.ApiManager
import com.udacity.political.preparedness.data.util.RetrofitErrorUtil
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionDetailServiceDataStore : ElectionDetailDataStore {

    override suspend fun get(
        id: String,
        address: String
    ): ResultType<ElectionDetailModel, ErrorModel> {
        val response = ApiManager.get().electionDetail(id, address)
        return if (response.isSuccessful) {
            val detailResponse = response.body()
            ResultType.Success(ElectionDetailMapper.transformResponseToModel(detailResponse!!))
        } else {
            val error = RetrofitErrorUtil.parseError(response)!!
            ResultType.Error(ErrorMapper.transformResponseToModel(error))
        }
    }

}