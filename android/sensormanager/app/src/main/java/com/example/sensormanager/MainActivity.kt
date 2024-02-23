package com.example.sensormanager

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener,SensorEventListener {
  lateinit var spinner:Spinner
  lateinit var txtInfo:TextView
  lateinit var txtData:TextView
  lateinit var allsensor:MutableList<Sensor>
  lateinit var manager:SensorManager
  lateinit var sensor:Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    spinner=findViewById(R.id.spinner)
    txtInfo=findViewById(R.id.tInfo)
    txtData=findViewById(R.id.tData)
      manager=getSystemService(SENSOR_SERVICE) as SensorManager
      allsensor=manager.getSensorList(Sensor.TYPE_ALL)
    var sensor_name= mutableListOf<String>()
    for(name in allsensor)sensor_name.add(name.name)
     var adapter=ArrayAdapter(this,
       androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sensor_name)
    spinner.adapter=adapter
      spinner.onItemSelectedListener=this; sensor=allsensor[0]
    }
    override fun onPause() {
        super.onPause()
        manager.unregisterListener(this,sensor)
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
if (sensor!=null) manager.unregisterListener(this,sensor)
sensor=allsensor[position]
txtInfo.text="Name:${sensor.name}\nVender:${sensor.vendor}\nVersion:${sensor.version
}\nMax:${sensor.maximumRange}\nResolution${sensor.resolution}"
 manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
  override fun onSensorChanged(event: SensorEvent?) {
var msg:String=""; for((index,item) in event!!.values.withIndex())msg+="Parameter[$index]=$item\n"
  txtData.text=msg
  }

  override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

  }
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}