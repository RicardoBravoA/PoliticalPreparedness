package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.storage.entity.SavedElectionEntity
import com.udacity.political.preparedness.data.util.ElectionUtil
import com.udacity.political.preparedness.domain.model.DivisionModel
import com.udacity.political.preparedness.domain.model.ElectionModel

object SavedElectionMapper {

    fun transformEntityToModel(savedElectionEntityList: List<SavedElectionEntity>): List<ElectionModel> {
        val electionModelList = mutableListOf<ElectionModel>()

        savedElectionEntityList.forEach {
            electionModelList.add(transformElectionEntityToModel(it))
        }
        return electionModelList
    }

    private fun transformElectionEntityToModel(savedElectionEntity: SavedElectionEntity): ElectionModel {
        savedElectionEntity.apply {
            return ElectionModel(id, name, electionDay, transformDivisionStringToModel(divisionId))
        }
    }

    private fun transformDivisionStringToModel(divisionId: String): DivisionModel {
        return ElectionUtil.divisionFromJson(divisionId)
    }

}