package com.udacity.political.preparedness.data.storage

import com.udacity.political.preparedness.data.datastore.SavedElectionDetailDataStore
import com.udacity.political.preparedness.data.mapper.ElectionDetailMapper
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.storage.database.ElectionDetailDao
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavedElectionDetailStorageDataStore(private val electionDetailDao: ElectionDetailDao) :
    SavedElectionDetailDataStore {

    override suspend fun get(
        id: String,
        address: String
    ): ResultType<ElectionDetailModel, ErrorModel> =
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

    override suspend fun save(electionDetailModel: ElectionDetailModel) =
        withContext(Dispatchers.IO) {
            electionDetailDao.insertElectionDetail(
                ElectionDetailMapper.transformModelToEntity(
                    electionDetailModel
                )
            )
        }

}