package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.response.AddressResponse
import com.udacity.political.preparedness.data.response.representative.ChannelResponse
import com.udacity.political.preparedness.data.response.representative.OfficeResponse
import com.udacity.political.preparedness.data.response.representative.OfficialResponse
import com.udacity.political.preparedness.data.response.representative.RepresentativeResponse
import com.udacity.political.preparedness.domain.model.representative.*

object RepresentativeMapper {

    fun transformResponseToModel(representativeResponse: RepresentativeResponse): List<RepresentativeModel> {
        /*return RepresentativeModel(
            transformListOfficeResponseToModel(representativeResponse.offices),
            transformListOfficialResponseToModel(representativeResponse.officials)
        )*/

        val list = mutableListOf<RepresentativeModel>()
        representativeResponse.offices.forEach { offices ->
            val indices = offices.officials
            indices.forEach { index ->
                val official = representativeResponse.officials[index]
                list.add(
                    RepresentativeModel(
                        index,
                        official.photoUrl,
                        offices.name,
                        official.name,
                        official.party,
                        official.urls?.firstOrNull(),
                        getFacebookUrl(official.channels),
                        getTwitterUrl(official.channels)
                    )
                )
            }
        }

        return list
    }

    private fun getFacebookUrl(channels: List<ChannelResponse>?): String? {
        return channels?.filter { channel -> channel.type == "Facebook" }
            ?.map { channel -> "https://www.facebook.com/${channel.id}" }
            ?.firstOrNull()
    }

    private fun getTwitterUrl(channels: List<ChannelResponse>?): String? {
        return channels?.filter { channel -> channel.type == "Twitter" }
            ?.map { channel -> "https://www.twitter.com/${channel.id}" }
            ?.firstOrNull()
    }

    private fun transformListOfficeResponseToModel(officeResponseList: List<OfficeResponse>): List<OfficeModel> {
        val list = mutableListOf<OfficeModel>()
        officeResponseList.forEach {
            list.add(transformOfficeResponseToModel(it))
        }
        return list
    }

    private fun transformOfficeResponseToModel(officeResponse: OfficeResponse): OfficeModel {
        officeResponse.apply {
            return OfficeModel(
                name,
                DivisionMapper.transformStringToModel(division),
                officials
            )
        }
    }

    private fun transformListOfficialResponseToModel(officialResponseList: List<OfficialResponse>): List<OfficialModel> {
        val list = mutableListOf<OfficialModel>()
        officialResponseList.forEach {
            list.add(transformOfficialResponseToModel(it))
        }
        return list
    }

    private fun transformOfficialResponseToModel(officialResponse: OfficialResponse): OfficialModel {
        officialResponse.apply {
            return OfficialModel(
                name,
                transformListAddressResponseToModel(address),
                party,
                phones,
                urls,
                photoUrl,
                transformListChannelResponseToModel(channels)
            )
        }
    }

    private fun transformListAddressResponseToModel(addressResponseList: List<AddressResponse>?): List<AddressModel> {
        val list = mutableListOf<AddressModel>()
        addressResponseList?.forEach {
            list.add(transformAddressResponseToModel(it))
        }
        return list
    }

    private fun transformAddressResponseToModel(addressResponse: AddressResponse): AddressModel {
        addressResponse.apply {
            return AddressModel(line1, line2, city, state, zip)
        }
    }

    private fun transformListChannelResponseToModel(channelResponseList: List<ChannelResponse>?): List<ChannelModel> {
        val list = mutableListOf<ChannelModel>()
        channelResponseList?.forEach {
            list.add(transformChannelResponseToModel(it))
        }
        return list
    }

    private fun transformChannelResponseToModel(channelResponse: ChannelResponse): ChannelModel {
        channelResponse.apply {
            return ChannelModel(type, id)
        }
    }

}