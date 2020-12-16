package com.udacity.political.preparedness.data.storage

import com.udacity.political.preparedness.data.datastore.ElectionDataStore
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.mapper.SavedElectionMapper
import com.udacity.political.preparedness.data.storage.database.SavedElectionDao
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavedElectionStorageDataStore(private val savedElectionDao: SavedElectionDao) :
    ElectionDataStore {

    override suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = savedElectionDao.getSavedElections()
                return@withContext ResultType.Success(
                    SavedElectionMapper.transformEntityToModel(
                        response
                    )
                )
            } catch (t: Throwable) {
                return@withContext ResultType.Error(ErrorMapper.errorModelDefault())
            }
        }

}