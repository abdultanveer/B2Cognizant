package com.example.b2cognizant

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    override fun onStart() {
        super.onStart()

    }


companion object {
    var TAG = LocationActivity::class.java.simpleName
}


    @SuppressLint("MissingPermission")
    fun getLocation(view: View) {
        fusedLocationClient.lastLocation  //location service hosted in google play
            .addOnSuccessListener { location : Location? ->
                Log.i(TAG,"latitude="+location?.latitude+"--longitude="+location?.longitude)

            }

    }


}