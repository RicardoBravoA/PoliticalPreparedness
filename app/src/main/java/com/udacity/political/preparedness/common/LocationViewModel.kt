package com.udacity.political.preparedness.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {

    private val _gpsStatus = MutableLiveData<Boolean>()
    val gpsStatus: LiveData<Boolean>
        get() = _gpsStatus

    private val _address = MutableLiveData<String>()
    val address: LiveData<String>
        get() = _address

    fun addGPSStatus(value: Boolean) {
        _gpsStatus.value = value
    }

    fun clearGPSStatus() {
        _gpsStatus.value = false
    }

}