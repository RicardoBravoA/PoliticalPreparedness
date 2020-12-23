package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionLocalDataRepositoryTest(private var list: LinkedHashMap<String, ElectionModel>) :
    ElectionRepository {

    override suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> {
        return ResultType.Success(list.values.toList())
    }

    fun saveReminder(electionModel: ElectionModel) {
        list[electionModel.id] = electionModel
    }

    fun delete() {
        list.clear()
    }

}