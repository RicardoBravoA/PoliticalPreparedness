package com.udacity.political.preparedness.representative

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.R
import com.udacity.political.preparedness.data.util.Constant
import com.udacity.political.preparedness.data.util.isInternet
import com.udacity.political.preparedness.domain.model.representative.AddressModel
import com.udacity.political.preparedness.domain.usecase.RepresentativeUseCase
import kotlinx.coroutines.launch

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

    private val _showForm = MutableLiveData<Boolean>()
    val showForm: LiveData<Boolean>
        get() = _showForm

    private val _showErrorForm = MutableLiveData<Boolean>()
    val showErrorForm: LiveData<Boolean>
        get() = _showErrorForm

    private val _addressModel = MutableLiveData<AddressModel>()
    val addressModel: LiveData<AddressModel>
        get() = _addressModel

    fun validateInternet() {
        val internet = context.isInternet()
        Log.i("z- internet", internet.toString())

        _showForm.value = internet
        _showErrorForm.value = !internet
    }

    fun find(line1: String?, line2: String?, city: String?, state: String?, zip: String?) {
        Log.i("z- find", "$line1 -  $line2 - $city - $state - $zip")

        val address: String = RepresentativeMapper.address(line1, line2, city, state, zip)

        viewModelScope.launch {
            representativeUseCase.get(address)
        }

    }

    fun showAddress(geocoder: Geocoder, location: Location) {
        val addressModel = geocoder.getFromLocation(location.latitude, location.longitude, 1)
            .map { address ->
                AddressModel(
                    address.thoroughfare,
                    address.subThoroughfare,
                    address.locality,
                    address.adminArea,
                    address.postalCode
                )
            }
            .first()
        _addressModel.value = addressModel
    }

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