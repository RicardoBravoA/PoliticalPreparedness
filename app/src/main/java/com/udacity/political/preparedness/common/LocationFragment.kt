package com.udacity.political.preparedness.common

import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class LocationFragment : Fragment(), LocationActivity.UpdateLocation {

    internal var location: Location? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        (requireActivity() as LocationActivity).setOnUpdateLocation(this)
        (requireActivity() as LocationActivity).permissionGPS()

        return view
    }

    override fun onUpdateLocation(location: Location) {
        this.location = location
        Log.i("z- onUpdateLocation", location.toString())
    }

}