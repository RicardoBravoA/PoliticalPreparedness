package com.udacity.political.preparedness.common

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.udacity.political.preparedness.R

abstract class LocationFragment : Fragment(), LocationActivity.UpdateLocation,
    LocationActivity.GPSStatus {

    internal var location: Location? = null
    internal val locationViewModel: LocationViewModel by lazy {
        ViewModelProvider(this, LocationViewModelFactory()).get(
            LocationViewModel::class.java
        )
    }
    private var snackbar: Snackbar? = null

    abstract fun layoutParent(): View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        (requireActivity() as LocationActivity).setOnUpdateLocation(this)
        (requireActivity() as LocationActivity).setOnGPSStatus(this)
        (requireActivity() as LocationActivity).permissionGPS()

        locationViewModel.gpsStatus.observe(viewLifecycleOwner, { status ->
            if (status) {
                location?.let {
                    locationViewModel.geocode("${it.latitude},${it.longitude}")
                    dismissSnackbar()
                }
            } else {
                showSnackbar()
            }
        })

        return view
    }

    override fun onUpdateLocation(location: Location) {
        this.location = location
    }

    override fun onGPSStatus(status: Boolean) {
        locationViewModel.addGPSStatus(status)
    }

    private fun showSnackbar() {
        if (snackbar == null) {
            snackbar = Snackbar.make(
                layoutParent(),
                getString(R.string.gps_message),
                Snackbar.LENGTH_INDEFINITE
            ).setAction(
                getString(R.string.ok)
            ) {
                dismissSnackbar()
                (requireActivity() as LocationActivity).permissionGPS()
            }
        }
        snackbar?.show()
    }

    private fun dismissSnackbar() {
        snackbar?.dismiss()
    }

    override fun onDestroyView() {
        dismissSnackbar()
        super.onDestroyView()
    }

}