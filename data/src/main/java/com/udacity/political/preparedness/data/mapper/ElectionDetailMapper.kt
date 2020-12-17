package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.response.detail.ElectionDetailResponse
import com.udacity.political.preparedness.data.response.detail.NormalizedInputResponse
import com.udacity.political.preparedness.data.storage.entity.ElectionDetailEntity
import com.udacity.political.preparedness.domain.model.ElectionDetailModel

object ElectionDetailMapper {

    fun transformResponseToEntity(electionDetailResponse: ElectionDetailResponse): ElectionDetailEntity {
        val election = electionDetailResponse.election
        val administration = electionDetailResponse.state.first().electionAdministrationBody
        return ElectionDetailEntity(
            election.id,
            election.name,
            election.electionDay,
            election.divisionId,
            administration.electionInfoUrl,
            administration.votingLocationFinderUrl,
            administration.ballotInfoUrl,
            transformAddress(electionDetailResponse.normalizedInput)
        )
    }

    fun transformEntityToModel(electionDetailEntity: ElectionDetailEntity): ElectionDetailModel {
        electionDetailEntity.apply {
            return ElectionDetailModel(
                id,
                name,
                electionDay,
                DivisionMapper.transformStringToModel(divisionId),
                electionInfoUrl,
                votingLocationFinderUrl,
                ballotInfoUrl,
                address
            )
        }
    }

    fun transformResponseToModel(electionDetailResponse: ElectionDetailResponse): ElectionDetailModel {
        val election = electionDetailResponse.election
        val administration = electionDetailResponse.state.first().electionAdministrationBody
        return ElectionDetailModel(
            election.id,
            election.name,
            election.electionDay,
            DivisionMapper.transformStringToModel(election.divisionId),
            administration.electionInfoUrl,
            administration.votingLocationFinderUrl,
            administration.ballotInfoUrl,
            transformAddress(electionDetailResponse.normalizedInput)
        )
    }

    private fun transformAddress(normalizedInputResponse: NormalizedInputResponse?): String? {
        normalizedInputResponse?.let {
            return "${it.line1}, ${it.city}, ${it.state} ${it.zip}"
        }
        return null
    }
}