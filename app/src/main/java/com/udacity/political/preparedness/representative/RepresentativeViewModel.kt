package com.udacity.political.preparedness.representative

import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.R
import com.udacity.political.preparedness.data.util.isInternet
import com.udacity.political.preparedness.domain.model.representative.AddressModel
import com.udacity.political.preparedness.domain.model.representative.RepresentativeModel
import com.udacity.political.preparedness.domain.usecase.RepresentativeUseCase
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.launch

class RepresentativeViewModel(
    private val context: Context,
    private val representativeUseCase: RepresentativeUseCase
) :
    ViewModel() {

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

    private val _data = MutableLiveData<List<RepresentativeModel>>()
    val data: LiveData<List<RepresentativeModel>>
        get() = _data

    fun validateInternet() {
        val internet = context.isInternet()

        _showForm.value = internet
        _showErrorForm.value = !internet
    }

    fun find(line1: String?, line2: String?, city: String?, state: String?, zip: String?) {

        val address: String = RepresentativeMapper.address(line1, line2, city, state, zip)

        viewModelScope.launch {
            when (val result = representativeUseCase.get(address)) {
                is ResultType.Success -> {
                    _data.value = result.value
                }
                is ResultType.Error -> {
                    //Do nothing
                }
            }
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

    fun loadSpinner() {
        val list =
            listOf(*context.resources.getStringArray(R.array.states))

        _stateList.value = list
    }


}