package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.response.ElectionDetailResponse
import com.udacity.political.preparedness.data.storage.entity.ElectionDetailEntity
import com.udacity.political.preparedness.domain.model.ElectionDetailModel

object ElectionDetailMapper {

    private fun transformEntityToModel(electionDetailEntity: ElectionDetailEntity): ElectionDetailModel {
        electionDetailEntity.apply {
            return ElectionDetailModel(
                id,
                name,
                electionDay,
                DivisionMapper.transformStringToModel(divisionId),
                electionInfoUrl,
                votingLocationFinderUrl,
                ballotInfoUrl
            )
        }
    }

    fun transformResponseToModel(electionDetailResponse: ElectionDetailResponse): ElectionDetailModel {
        val election = electionDetailResponse.election
        val administration = electionDetailResponse.state.electionAdministrationBody
        return ElectionDetailModel(
            election.id,
            election.name,
            election.electionDay,
            DivisionMapper.transformStringToModel(election.divisionId),
            administration.electionInfoUrl,
            administration.votingLocationFinderUrl,
            administration.ballotInfoUrl
        )
    }
}