package com.udacity.political.preparedness.data.storage

import com.udacity.political.preparedness.data.datastore.ElectionDetailDataStore
import com.udacity.political.preparedness.data.mapper.ElectionDetailMapper
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.storage.database.ElectionDetailDao
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ElectionDetailStorageDataStore(private val electionDetailDao: ElectionDetailDao) :
    ElectionDetailDataStore {

    override suspend fun get(id: String): ResultType<ElectionDetailModel, ErrorModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = electionDetailDao.getElectionDetail(id)
                return@withContext ResultType.Success(
                    ElectionDetailMapper.transformEntityToModel(
                        response
                    )
                )
            } catch (t: Throwable) {
                return@withContext ResultType.Error(ErrorMapper.errorModelDefault())
            }
        }

}