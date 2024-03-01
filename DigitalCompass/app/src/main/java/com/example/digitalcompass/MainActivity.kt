package com.example.digitalcompass

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.atan2

class MainActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener,SensorEventListener {
    lateinit var seekbar:SeekBar
    lateinit var dial:ImageView
    lateinit var txtBearing:TextView
    lateinit var manager:SensorManager
    lateinit var sensor:Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    seekbar=findViewById(R.id.seekBar)
    dial=findViewById(R.id.iDial)
    txtBearing=findViewById(R.id.tBearing)
    seekbar.max=360;seekbar.progress=180;seekbar.setOnSeekBarChangeListener(this)
    manager=getSystemService(SENSOR_SERVICE) as SensorManager
    sensor=manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) as Sensor
    }
    override fun onResume() {
        super.onResume()
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause() {
        super.onPause()
        manager.unregisterListener(this,sensor)
    }
    override fun onSensorChanged(event: SensorEvent?) {
var x=event!!.values[0];var y=event!!.values[1]
 var degree= (-atan2(y.toDouble(),x.toDouble())/PI)*180; txtBearing.text="$degree"
 dial.rotation=degree.toFloat()-180
    }
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
   dial.rotation=seekBar!!.progress.toFloat()-180
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}