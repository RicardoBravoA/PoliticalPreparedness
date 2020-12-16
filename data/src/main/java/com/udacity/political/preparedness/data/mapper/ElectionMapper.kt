package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.response.ElectionItemResponse
import com.udacity.political.preparedness.data.response.ElectionResponse
import com.udacity.political.preparedness.data.storage.entity.ElectionEntity
import com.udacity.political.preparedness.data.util.ElectionUtil
import com.udacity.political.preparedness.domain.model.DivisionModel
import com.udacity.political.preparedness.domain.model.ElectionModel

object ElectionMapper {

    fun transformElectionResponseToEntity(electionItemResponse: ElectionItemResponse): ElectionEntity {
        electionItemResponse.apply {
            return ElectionEntity(
                id,
                name,
                electionDay,
                divisionId
            )
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
            return ElectionModel(id, name, electionDay, transformDivisionStringToModel(divisionId))
        }
    }

    private fun transformDivisionStringToModel(divisionId: String): DivisionModel {
        return ElectionUtil.divisionFromJson(divisionId)
    }

    fun transformResponseToModel(electionResponse: ElectionResponse?): List<ElectionModel> {
        val electionModelList = mutableListOf<ElectionModel>()

        electionResponse?.elections?.forEach {
            electionModelList.add(transformElectionResponseToModel(it))
        }
        return electionModelList
    }

    private fun transformElectionResponseToModel(electionItemResponse: ElectionItemResponse): ElectionModel {
        electionItemResponse.apply {
            return ElectionModel(
                id,
                name,
                electionDay,
                transformDivisionStringToModel(divisionId)
            )
        }
    }
}