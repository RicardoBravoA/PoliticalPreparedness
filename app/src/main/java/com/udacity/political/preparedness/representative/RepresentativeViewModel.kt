package com.udacity.political.preparedness.representative

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.political.preparedness.R
import com.udacity.political.preparedness.domain.usecase.RepresentativeUseCase

class RepresentativeViewModel(
    private val context: Context,
    private val representativeUseCase: RepresentativeUseCase
) :
    ViewModel() {

    //TODO: Establish live data for representatives and address

    //TODO: Create function to fetch representatives from API from a provided address

    private val _stateList = MutableLiveData<List<String>>()
    val stateList: LiveData<List<String>>
        get() = _stateList


    /**
     *  The following code will prove helpful in constructing a representative from the API. This code combines the two nodes of the RepresentativeResponse into a single official :
    val (offices, officials) = getRepresentativesDeferred.await()
    _representatives.value = offices.flatMap { office -> office.getRepresentatives(officials) }
    Note: getRepresentatives in the above code represents the method used to fetch data from the API
    Note: _representatives in the above code represents the established mutable live data housing representatives
     */

    //TODO: Create function get address from geo location

    //TODO: Create function to get address from individual fields

    fun loadSpinner() {
        val list =
            listOf(*context.resources.getStringArray(R.array.states))

        _stateList.value = list
    }


}