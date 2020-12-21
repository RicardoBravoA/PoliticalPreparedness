package com.udacity.political.preparedness.common

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.domain.model.GeocodeModel
import com.udacity.political.preparedness.domain.usecase.GeocodeUseCase
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.launch

class LocationViewModel(private val geocodeUseCase: GeocodeUseCase) : ViewModel() {

    private val _gpsStatus = MutableLiveData<Boolean>()
    val gpsStatus: LiveData<Boolean>
        get() = _gpsStatus

    private val _address = MutableLiveData<GeocodeModel>()
    val address: LiveData<GeocodeModel>
        get() = _address

    private val _location = MutableLiveData<Location>()
    val location: LiveData<Location>
        get() = _location

    fun addGPSStatus(value: Boolean) {
        _gpsStatus.value = value
    }

    fun clearGPSStatus() {
        _gpsStatus.value = false
    }

    fun location(location: Location) {
        _location.value = location
    }

    fun geocode(coordinates: String) {
        viewModelScope.launch {
            when (val result = geocodeUseCase.get(coordinates)) {
                is ResultType.Success -> {
                    Log.i("z- data", result.value.toString())
                    _address.value = result.value
                }
                is ResultType.Error -> {
                    Log.i("z- error", result.value.toString())
                }
            }
        }
    }

}