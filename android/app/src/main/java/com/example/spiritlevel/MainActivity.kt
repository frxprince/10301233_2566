package com.example.spiritlevel

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.atan2

class MainActivity : AppCompatActivity(),SensorEventListener {
   lateinit var txtData:TextView
   lateinit var txtDegree:TextView
   lateinit var seekbar:SeekBar
   lateinit var manager:SensorManager
   lateinit var sensor:Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtData=findViewById(R.id.tData)
        txtDegree=findViewById(R.id.tDegree)
        seekbar=findViewById(R.id.seekBar)
    manager=getSystemService(SENSOR_SERVICE) as SensorManager
    sensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) as Sensor
        seekbar.max=180
    }
    override fun onSensorChanged(event: SensorEvent?) {
      var x=event!!.values[0];var y=event!!.values[1];var z=event!!.values[2]
    txtData.text="X:$x\nY:$y\nZ:$z"
     var degree=  180-((atan2(x,y)/PI)*180.0)-90
     txtDegree.text="$degree" ; seekbar.progress=90-degree.toInt()
    }
    override fun onResume() {
        super.onResume()
    manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause() {
        super.onPause()
    manager.unregisterListener(this,sensor)
    }



    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}