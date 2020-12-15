package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.entity.DivisionResponse
import com.udacity.political.preparedness.data.entity.ElectionResponse
import com.udacity.political.preparedness.data.storage.entity.DivisionEntity
import com.udacity.political.preparedness.data.storage.entity.ElectionEntity
import com.udacity.political.preparedness.domain.model.DivisionModel
import com.udacity.political.preparedness.domain.model.ElectionModel

object ElectionMapper {

    fun transformElectionResponseToEntity(electionResponse: ElectionResponse): ElectionEntity {
        electionResponse.apply {
            return ElectionEntity(
                id,
                name,
                electionDay,
                transformDivisionResponseToEntity(divisionResponse)
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
            return ElectionModel(name, electionDay, transformDivisionEntityToModel(divisionEntity))
        }
    }

    private fun transformDivisionEntityToModel(divisionEntity: DivisionEntity): DivisionModel {
        divisionEntity.apply {
            return DivisionModel(id, country, state)
        }
    }

    fun transformResponseToModel(electionResponseList: List<ElectionResponse>): List<ElectionModel> {
        val electionModelList = mutableListOf<ElectionModel>()

        electionResponseList.forEach {
            electionModelList.add(transformElectionResponseToModel(it))
        }
        return electionModelList
    }

    private fun transformElectionResponseToModel(electionResponse: ElectionResponse): ElectionModel {
        electionResponse.apply {
            return ElectionModel(
                name,
                electionDay,
                transformDivisionResponseToModel(divisionResponse)
            )
        }
    }

    private fun transformDivisionResponseToModel(divisionResponse: DivisionResponse): DivisionModel {
        divisionResponse.apply {
            return DivisionModel(id, country, state)
        }
    }

    private fun transformDivisionResponseToEntity(divisionResponse: DivisionResponse): DivisionEntity {
        divisionResponse.apply {
            return DivisionEntity(id, country, state)
        }
    }


}