package com.udacity.political.preparedness.data.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.udacity.political.preparedness.data.storage.entity.DivisionEntity

class ElectionUtil {

    @FromJson
    fun divisionFromJson(ocdDivisionId: String): DivisionEntity {
        val countryDelimiter = "country:"
        val stateDelimiter = "state:"
        val country = ocdDivisionId.substringAfter(countryDelimiter, "")
            .substringBefore("/")
        val state = ocdDivisionId.substringAfter(stateDelimiter, "")
            .substringBefore("/")
        return DivisionEntity(ocdDivisionId, country, state)
    }

    @ToJson
    fun divisionToJson(divisionEntity: DivisionEntity): String {
        return divisionEntity.id
    }

}
