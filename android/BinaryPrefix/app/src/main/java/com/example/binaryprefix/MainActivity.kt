package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_main)
 val txtWelcome=findViewById<TextView>(R.id.tWelcome)
 txtWelcome.startAnimation(AnimationUtils.loadAnimation(this,R.anim.blink))
 txtWelcome.setOnClickListener {
  val i= Intent(this,Activity2::class.java)
  startActivity(i)
 }
    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }
}