package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.response.geocode.GeocodeResponse
import com.udacity.political.preparedness.data.response.representative.RepresentativeResponse
import com.udacity.political.preparedness.domain.model.GeocodeModel

object RepresentativeMapper {

    fun transformResponseToModel(representativeResponse: RepresentativeResponse): GeocodeModel {
        return GeocodeModel(geocodeResponse.results.first().address)
    }
}