package com.example.mybatterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
 lateinit var Battery:MyReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   val txtMesage=findViewById<TextView>(R.id.tMessage)
   val progress=findViewById<ProgressBar>(R.id.progressBar)
        progress.max=100
  Battery=object:MyReceiver(){
      override fun show(battValue: Float, charging: Int) {
   var USB=when(charging){
       BatteryManager.BATTERY_STATUS_FULL->"Battery fully charged"
       BatteryManager.BATTERY_STATUS_NOT_CHARGING->"Not charge"
       BatteryManager.BATTERY_STATUS_DISCHARGING->"Discharging"
       BatteryManager.BATTERY_STATUS_CHARGING->"Charging"
       else->"others"
   }
      txtMesage.text=" $battValue   $charging \n $USB "
      progress.progress=battValue.toInt()
      }
  }
 registerReceiver(Battery, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onPause() {
        super.onPause()
 unregisterReceiver(Battery)
    }

    abstract class MyReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
   var level=intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)?:0
   var scale=intent?.getIntExtra(BatteryManager.EXTRA_SCALE,1)?:1
   var battValue=(level/scale.toFloat())*100
   var charging=intent?.getIntExtra(BatteryManager.EXTRA_STATUS,0)?:0
 show(battValue,charging)
    Log.v("Battery",level.toString())
    }
 abstract fun show(battValue:Float,charging:Int)
}
}