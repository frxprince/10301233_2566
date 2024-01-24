package com.example.soundplayer

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnResoure=findViewById<Button>(R.id.bResource)
        var btnAssets=findViewById<Button>(R.id.bAssets)
        var btnInternet= findViewById<Button>(R.id.bInternet)
        var btnSDCARD=findViewById<Button>(R.id.bSDCARD)
        var btnPlay=findViewById<Button>(R.id.bPlay)
        var btnPause=findViewById<Button>(R.id.bPause)
        val btnStop=findViewById<Button>(R.id.bStop)
        lateinit var Mp:MediaPlayer
        btnResoure.setOnClickListener {
            Mp= MediaPlayer()
            Mp=MediaPlayer.create(this,R.raw.greeting)
        }
        btnPlay.setOnClickListener { Mp.start() }
    btnAssets.setOnClickListener {
    var mp3file=assets.openFd("mp3/cat.mp3")
    Mp=MediaPlayer()
    Mp.setDataSource(mp3file.fileDescriptor,mp3file.startOffset,mp3file.length)
    Mp.prepare()
    }
    btnPause.setOnClickListener { Mp.pause() }
    btnStop.setOnClickListener { Mp.stop() }
    btnInternet.setOnClickListener {
   Mp=MediaPlayer()
   Mp.setDataSource(this, Uri.parse(
       "https://www.drpaween.com/ohm/mp3test.mp3"))
   Mp.prepare()
    }

    }
}