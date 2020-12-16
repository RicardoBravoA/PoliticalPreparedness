package com.udacity.political.preparedness.data.mapper

import com.udacity.political.preparedness.data.util.ElectionUtil
import com.udacity.political.preparedness.domain.model.DivisionModel

object DivisionMapper {

    fun transformStringToModel(divisionId: String): DivisionModel {
        return ElectionUtil.divisionFromJson(divisionId)
    }

}