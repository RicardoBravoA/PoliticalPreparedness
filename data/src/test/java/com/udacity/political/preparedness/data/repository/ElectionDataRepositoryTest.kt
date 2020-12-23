package com.udacity.political.preparedness.data.repository

import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.model.ErrorModel
import com.udacity.political.preparedness.domain.repository.ElectionRepository
import com.udacity.political.preparedness.domain.util.ResultType

class ElectionDataRepositoryTest : ElectionRepository {

    var data: LinkedHashMap<String, ElectionModel> = LinkedHashMap()
    private val error = ErrorModel(ErrorModel.Error(0, "Error", "status"))

    private var shouldReturnError = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override suspend fun get(): ResultType<List<ElectionModel>, ErrorModel> {
        if (shouldReturnError) {
            return ResultType.Error(error)
        }
        return ResultType.Success(data.values.toList())
    }

    fun save(electionModel: ElectionModel) {
        data[electionModel.id] = electionModel
    }

    fun delete() {
        data.clear()
    }

}