package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 val txtWelcome=findViewById<TextView>(R.id.tWelcome)
 txtWelcome.setOnClickListener {
  val i= Intent(this,Activity2::class.java)
  startActivity(i)
 }
    }
}