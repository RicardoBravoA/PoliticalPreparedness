package com.udacity.political.preparedness.data.storage

import com.udacity.political.preparedness.data.datastore.SavedElectionDetailDataStore
import com.udacity.political.preparedness.data.mapper.ElectionDetailMapper
import com.udacity.political.preparedness.data.mapper.ErrorMapper
import com.udacity.political.preparedness.data.storage.database.SavedElectionDetailDao
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavedElectionDetailStorageDataStore(private val savedElectionDetailDao: SavedElectionDetailDao) :
    SavedElectionDetailDataStore {

    override suspend fun get(
        id: String,
        address: String
    ): ResultType<ElectionDetailModel, ErrorModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = savedElectionDetailDao.getElectionDetail(id)
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
            savedElectionDetailDao.insertElectionDetail(
                ElectionDetailMapper.transformModelToEntity(
                    electionDetailModel
                )
            )
        }

    override suspend fun getAll(): ResultType<List<ElectionDetailModel>, ErrorModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = savedElectionDetailDao.getAllElectionDetail()
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