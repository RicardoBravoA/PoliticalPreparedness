package com.udacity.political.preparedness.common

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.udacity.political.preparedness.util.Constant
import com.udacity.political.preparedness.util.GpsUtil

abstract class LocationActivity : AppCompatActivity(), LocationListener {

    private lateinit var locationManager: LocationManager
    private var updateLocation: UpdateLocation? = null
    private var gpsStatus: GPSStatus? = null

    fun setOnUpdateLocation(updateLocation: UpdateLocation) {
        this.updateLocation = updateLocation
    }

    fun setOnGPSStatus(gpsStatus: GPSStatus) {
        this.gpsStatus = gpsStatus
    }

    fun permissionGPS() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            }
        } else {
            activateGPS()
        }
    }

    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                Constant.GPS
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }

    private fun activateGPS() {
        GpsUtil(this).turnOnGPS(object : GpsUtil.GpsListener {
            override fun onGpsStatus(isGPSEnable: Boolean) {
                gpsStatus?.onGPSStatus(isGPSEnable)
                getLocation()
            }
        })
    }

    override fun onLocationChanged(location: Location) {
        updateLocation?.onUpdateLocation(location)
    }

    override fun onProviderEnabled(provider: String) {
        //Do nothing
    }

    override fun onProviderDisabled(provider: String) {
        //Do nothing
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    if ((ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) ==
                                PackageManager.PERMISSION_GRANTED)
                    ) {
                        activateGPS()
                    }
                }
                return
            }
        }
    }

    interface UpdateLocation {
        fun onUpdateLocation(location: Location)
    }

    interface GPSStatus {
        fun onGPSStatus(status: Boolean)
    }

}