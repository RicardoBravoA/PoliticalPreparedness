package com.udacity.political.preparedness.representative

import com.udacity.political.preparedness.data.util.Constant

object RepresentativeMapper {

    fun address(
        line1: String?,
        line2: String?,
        city: String?,
        state: String?,
        zip: String?
    ): String {
        var address = Constant.EMPTY

        line2?.let {
            address = address.plus(it)
        }

        if (address.isNotEmpty()) {
            address = address.plus(Constant.SPACE)
        }

        line1?.let {
            address = address.plus(it)
        }

        if (address.isNotEmpty()) {
            address = address.plus(Constant.SPACE)
        }

        city?.let {
            address = address.plus(it)
        }

        if (address.isNotEmpty()) {
            address = address.plus(Constant.SPACE)
        }

        state?.let {
            address = address.plus(it)
        }

        if (address.isNotEmpty()) {
            address = address.plus(Constant.SPACE)
        }

        zip?.let {
            address = address.plus(it)
        }

        if (address.isNotEmpty()) {
            address = address.plus(Constant.SPACE)
        }

        return address
    }

}