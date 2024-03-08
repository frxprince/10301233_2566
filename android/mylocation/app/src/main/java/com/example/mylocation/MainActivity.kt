package com.example.mylocation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.getSystemService
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(),LocationListener {
  lateinit var txtLocation:TextView
  lateinit var txtNMEA:TextView
  lateinit var btnClear: Button
  lateinit var GPS:LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 txtNMEA=findViewById(R.id.tNMEA);txtLocation=findViewById(R.id.tLocation);btnClear=findViewById(R.id.bClear)
if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
  requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
      Manifest.permission.ACCESS_COARSE_LOCATION),1234)
  GPS=getSystemService(LOCATION_SERVICE) as LocationManager
    }
    override fun onResume() { super.onResume();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        GPS.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10f,this)     }
   override fun onPause() { super.onPause()    }
    override fun onLocationChanged(location: Location) {
txtLocation.text="Lat:${location.longitude}\nLong:${location.longitude}\nAlt:${location.altitude}"+
        "\nTime:${location.time}\nSpeed:${location.speed}\nBearing:${location.bearing}"
    }
}