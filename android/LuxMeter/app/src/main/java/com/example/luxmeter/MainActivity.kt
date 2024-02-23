package com.example.luxmeter

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var manager:SensorManager
    lateinit var sensor:Sensor
    lateinit var txtLux:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart=findViewById<Button>(R.id.bStart)
        val btnStop=findViewById<Button>(R.id.bStop)
        txtLux=findViewById(R.id.tLux)
    manager=getSystemService(SENSOR_SERVICE)as SensorManager
    sensor=manager.getDefaultSensor(Sensor.TYPE_LIGHT) as Sensor
btnStart.setOnClickListener { manager.registerListener(this,sensor,
    SensorManager.SENSOR_DELAY_NORMAL) }
btnStop.setOnClickListener { manager.unregisterListener(this,sensor) }
    }
    override fun onSensorChanged(event: SensorEvent?) {
  txtLux.text="${event!!.values[0]}"
           }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}