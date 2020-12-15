package com.udacity.political.preparedness.data.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.udacity.political.preparedness.domain.model.DivisionModel

object ElectionUtil {

    @FromJson
    fun divisionFromJson(divisionId: String): DivisionModel {
        val countryDelimiter = "country:"
        val stateDelimiter = "state:"
        val country = divisionId.substringAfter(countryDelimiter, "")
            .substringBefore("/")
        val state = divisionId.substringAfter(stateDelimiter, "")
            .substringBefore("/")
        return DivisionModel(divisionId, country, state)
    }

    @ToJson
    fun divisionToJson(divisionEntity: DivisionModel): String {
        return divisionEntity.id
    }

}
