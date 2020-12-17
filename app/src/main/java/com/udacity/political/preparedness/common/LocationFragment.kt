package com.udacity.political.preparedness.common

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.udacity.political.preparedness.util.Constant

abstract class LocationFragment : Fragment(), LocationListener {

    private lateinit var locationManager: LocationManager
    var location: Location? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        if (shouldShowRequestPermissionRationale(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Log.i("z- access", "con permiso gps")
        } else {
            Log.i("z- access", "sin permiso gps")
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), Constant.REQUEST_CODE
            )
        }

        return view
    }

    /*override fun onResume() {
        super.onResume()
    }

    private fun activateGPS() {
        GpsUtil(requireContext()).turnOnGPS(object : GpsUtil.GpsListener {
            override fun onGpsStatus(isGPSEnable: Boolean) {
                Log.i("z- activateGPS", isGPSEnable.toString())
                locationCallback()
            }
        })
    }*/

    override fun onLocationChanged(location: Location) {
        Log.i("z- location", "${location.latitude} - ${location.longitude}")
    }

    private fun getLocation() {

        locationManager =
            requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if ((ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                Constant.GPS
            )
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        Log.i("z- requestCode", requestCode.toString())
        if (requestCode == Constant.REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED
            ) {
                if ((ContextCompat.checkSelfPermission(
                        requireActivity(),
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) ==
                            PackageManager.PERMISSION_GRANTED)
                ) {
                    Log.i("z- response", "access")
                    getLocation()
                }
            } else {
                Log.i("z- response", "denied")
            }
            return
        } else if (requestCode == Constant.GPS) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i("z- gps", "1")
            } else {
                Log.i("z- gps", "2")
            }
        }
    }

}