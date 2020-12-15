package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.entity.ElectionResponse
import com.udacity.political.preparedness.data.storage.entity.ElectionEntity
import com.udacity.political.preparedness.domain.model.ElectionModel

object ElectionMapper {

    fun transformElectionResponseToEntity(electionResponse: ElectionResponse): ElectionEntity {
        electionResponse.apply {
            return ElectionEntity(id, name, electionDay, divisionEntity)
        }
    }

    fun transformEntityToModel(electionEntityList: List<ElectionEntity>): List<ElectionModel> {
        val electionModelList = mutableListOf<ElectionModel>()

        electionEntityList.forEach {
            electionModelList.add(transformElectionEntityToModel(it))
        }
        return electionModelList
    }

    private fun transformElectionEntityToModel(electionEntity: ElectionEntity): ElectionModel {
        electionEntity.apply {
            return ElectionModel(name, electionDay, divisionEntity)
        }
    }

}