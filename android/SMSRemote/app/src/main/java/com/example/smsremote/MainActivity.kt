package com.example.smsremote

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var Mp_alarm: MediaPlayer
    lateinit var Mp_cat: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnExit=findViewById<Button>(R.id.bExit)
if (checkSelfPermission(Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED)
 requestPermissions(arrayOf(Manifest.permission.RECEIVE_SMS),1234)
 btnExit.setOnClickListener { finish() }
Mp_cat= MediaPlayer.create(this,R.raw.cat)
Mp_alarm= MediaPlayer.create(this,R.raw.alarm)
if(intent.getStringExtra("data")=="cat")Mp_cat.start()
 if(intent.getStringExtra("data")=="alarm")Mp_alarm.start()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if(intent!!.getStringExtra("data")=="cat")Mp_cat.start()
        if(intent!!.getStringExtra("data")=="alarm")Mp_alarm.start()
    }
}
