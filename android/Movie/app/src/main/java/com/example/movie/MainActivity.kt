package com.example.movie

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val btnResource=findViewById<Button>(R.id.bResource)
        val btnInternet=findViewById<Button>(R.id.bInternet)
        val btnSDCARD=findViewById<Button>(R.id.bSDcard)
        val btnPlay=findViewById<Button>(R.id.bPlay)
        val btnPause=findViewById<Button>(R.id.bPause)
        val btnStop=findViewById<Button>(R.id.bStop)
        val Video=findViewById<VideoView>(R.id.Video)
    btnResource.setOnClickListener {
    Video.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+
    R.raw.video2))
    }
btnPlay.setOnClickListener { Video.start() }
        btnPause.setOnClickListener { Video.pause() }
        btnStop.setOnClickListener { Video.stopPlayback() }
 btnInternet.setOnClickListener {
 Video.setVideoURI(Uri.parse("https://www.drpaween.com/ohm/cs436/mv.mp4"))
 }
  Video.setMediaController(MediaController(this))
if(checkSelfPermission(Manifest.permission.READ_MEDIA_VIDEO)!=PackageManager.PERMISSION_GRANTED)
    requestPermissions(arrayOf(Manifest.permission.READ_MEDIA_VIDEO),1234)
btnSDCARD.setOnClickListener {
 Video.setVideoURI(Uri.parse("/sdcard/Loituma.3gp"))
}
    }
}