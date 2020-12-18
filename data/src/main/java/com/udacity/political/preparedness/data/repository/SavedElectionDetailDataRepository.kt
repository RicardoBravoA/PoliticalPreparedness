package com.udacity.political.preparedness.data.repository

import android.content.Context
import com.udacity.political.preparedness.data.storage.SavedElectionDetailStorageDataStore
import com.udacity.political.preparedness.data.storage.database.ElectionDatabase
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.SavedElectionDetailRepository
import com.udacity.political.preparedness.domain.util.ResultType

class SavedElectionDetailDataRepository(private val context: Context) :
    SavedElectionDetailRepository {

    override suspend fun get(
        id: String,
        address: String
    ): ResultType<ElectionDetailModel, ErrorModel> {
        val database = ElectionDatabase.getInstance(context)
        return SavedElectionDetailStorageDataStore(database.savedElectionDetailDao).get(id, address)
    }

    override suspend fun save(electionDetailModel: ElectionDetailModel) {
        val database = ElectionDatabase.getInstance(context)
        return SavedElectionDetailStorageDataStore(database.savedElectionDetailDao).save(
            electionDetailModel
        )
    }

    override suspend fun getAll(): ResultType<List<ElectionDetailModel>, ErrorModel> {
        val database = ElectionDatabase.getInstance(context)
        return SavedElectionDetailStorageDataStore(database.savedElectionDetailDao).getAll()
    }

}