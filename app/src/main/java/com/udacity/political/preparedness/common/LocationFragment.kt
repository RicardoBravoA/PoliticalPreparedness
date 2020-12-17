package com.udacity.political.preparedness.common

import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

open class LocationFragment : Fragment(), LocationActivity.UpdateLocation,
    LocationActivity.GPSStatus {

    internal var location: Location? = null
    private val viewModel: LocationViewModel by lazy {
        ViewModelProvider(this, LocationViewModelFactory()).get(
            LocationViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        (requireActivity() as LocationActivity).setOnUpdateLocation(this)
        (requireActivity() as LocationActivity).setOnGPSStatus(this)
        (requireActivity() as LocationActivity).permissionGPS()

        viewModel.gpsStatus.observe(viewLifecycleOwner, {
            if (it) {
                Log.i("z- gps", "encendido")
            } else {
                Log.i("z- gps", "apagado")
            }
        })
        return view
    }

    override fun onUpdateLocation(location: Location) {
        this.location = location
        Log.i("z- onUpdateLocation", location.toString())
    }

    override fun onGPSStatus(status: Boolean) {
        Log.i("z- onGPSStatus", status.toString())
        viewModel.addGPSStatus(status)
    }

}