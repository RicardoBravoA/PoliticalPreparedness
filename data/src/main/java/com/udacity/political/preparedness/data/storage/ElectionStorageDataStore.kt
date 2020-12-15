package com.udacity.political.preparedness.data.storage

import com.udacity.political.preparedness.data.datastore.ElectionDataStore
import com.udacity.political.preparedness.data.mapper.ElectionMapper
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.storage.database.ElectionDao
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ElectionStorageDataStore(private val electionDao: ElectionDao) : ElectionDataStore {

    override suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = electionDao.getElections()
                return@withContext ResultType.Success(ElectionMapper.transformEntityToModel(response))
            } catch (t: Throwable) {
                return@withContext ResultType.Error(ErrorMapper.errorModelDefault())
            }
        }

}