package com.udacity.political.preparedness.data.service

import com.udacity.political.preparedness.data.datastore.ElectionDataStore
import com.udacity.political.preparedness.data.datastore.ElectionDetailDataStore
import com.udacity.political.preparedness.data.response.ElectionItemResponse
import com.udacity.political.preparedness.data.mapper.ElectionMapper
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.network.ApiManager
import com.udacity.political.preparedness.data.storage.database.ElectionDao
import com.udacity.political.preparedness.data.storage.database.ElectionDetailDao
import com.udacity.political.preparedness.data.util.RetrofitErrorUtil
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ElectionDetailServiceDataStore(private val electionDetailDao: ElectionDetailDao) :
    ElectionDetailDataStore {

    override suspend fun get(): ResultType<List<ElectionDetailModel>, ErrorModel> {
        val response = ApiManager.get().electionDetail()
        return if (response.isSuccessful) {
            val electionResponse = response.body()
            save(electionDao, electionResponse?.elections)
            ResultType.Success(ElectionMapper.transformResponseToModel(electionResponse))
        } else {
            val error = RetrofitErrorUtil.parseError(response)!!
            ResultType.Error(ErrorMapper.transformResponseToModel(error))
        }
    }

    private suspend fun save(electionDetailDao: ElectionDetailDao, detail: ElectionDetailModel?) =
        withContext(Dispatchers.IO) {
            electionDetailDao.insertElectionDetail(
                ElectionMapper.transformElectionResponseToEntity(
                    it
                )
            )
        }

}