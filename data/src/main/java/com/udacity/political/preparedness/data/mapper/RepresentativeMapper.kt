package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.response.representative.RepresentativeResponse
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel

object RepresentativeMapper {

    fun transformResponseToModel(representativeResponse: RepresentativeResponse): RepresentativeModel {
        return GeocodeModel(geocodeResponse.results.first().address)
    }
}