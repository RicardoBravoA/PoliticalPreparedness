package com.udacity.political.preparedness.common

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.udacity.political.preparedness.util.Constant
import com.udacity.political.preparedness.util.GpsUtil

open class LocationActivity : AppCompatActivity(), LocationListener {

    private lateinit var locationManager: LocationManager

    fun permissionGPS() {
        Log.i("z- permission", "GPS")
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            Log.i("z- permissionX", "0")
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                Log.i("z- permissionX", "1")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            } else {
                Log.i("z- permissionX", "2")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            }
        } else {
            Log.i("z- permissionX", "3")
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
                Log.i("z- activateGPS", isGPSEnable.toString())
                getLocation()
            }
        })
    }

    override fun onLocationChanged(location: Location) {
        Log.i("z- location", "${location.latitude} - ${location.longitude}")
    }

    override fun onProviderEnabled(provider: String) {
    }

    override fun onProviderDisabled(provider: String) {
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
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
                    Log.i("z- permission", "0")
                    if ((ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) ==
                                PackageManager.PERMISSION_GRANTED)
                    ) {
                        Log.i("z- permission", "concedido")
                        activateGPS()
                    }
                } else {
                    Log.i("z- permission", "no concedido")
                }
                return
            }
            Constant.GPS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i("z- gps", "1")
                } else {
                    Log.i("z- gps", "2")
                }
            }
        }
    }

}