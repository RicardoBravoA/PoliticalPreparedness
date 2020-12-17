package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.response.geocode.GeocodeResponse
import com.udacity.political.preparedness.domain.model.GeocodeModel

object GeocodeMapper {

    fun transformResponseToModel(geocodeResponse: GeocodeResponse): GeocodeModel {
        return GeocodeModel(geocodeResponse.results.first().address)
    }
}