package com.udacity.political.preparedness.data.service

import com.udacity.political.preparedness.data.datastore.GeocodeDataStore
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.mapper.GeocodeMapper
import com.udacity.political.preparedness.data.network.ApiManager
import com.udacity.political.preparedness.data.util.RetrofitErrorUtil
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.model.GeocodeModel
import com.udacity.political.preparedness.domain.util.ResultType

class GeocodeServiceDataStore() : GeocodeDataStore {

    override suspend fun get(coordinates: String): ResultType<GeocodeModel, ErrorModel> {
        val response = ApiManager.get().geocode(latLng = coordinates)
        return if (response.isSuccessful) {
            val response = response.body()
            ResultType.Success(GeocodeMapper.transformResponseToModel(response!!))
        } else {
            val error = RetrofitErrorUtil.parseError(response)!!
            ResultType.Error(ErrorMapper.transformResponseToModel(error))
        }
    }


}