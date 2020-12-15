package com.udacity.political.preparedness.data.service

import com.udacity.political.preparedness.data.datastore.ElectionDataStore
import com.udacity.political.preparedness.data.mapper.ElectionMapper
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.network.ApiManager
import com.udacity.political.preparedness.data.storage.database.ElectionDao
import com.udacity.political.preparedness.data.util.RetrofitErrorUtil
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionServiceDataStore(private val electionDao: ElectionDao) : ElectionDataStore {

    override suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> {
        val response = ApiManager.get().elections()
        return if (response.isSuccessful) {
            val electionEntityList = response.body()
            ResultType.Success(ElectionMapper.transformResponseToModel(electionEntityList))
        } else {
            val error = RetrofitErrorUtil.parseError(response)!!
            ResultType.Error(ErrorMapper.transformResponseToModel(error))
        }
    }

}