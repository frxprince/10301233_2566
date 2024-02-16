package com.example.sendsms

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  val txtMessage=findViewById<EditText>(R.id.eMessage)
  val txtNumber=findViewById<EditText>(R.id.ePhoneNumber)
  val txtStatus=findViewById<TextView>(R.id.tStatus)
  val btnSend=findViewById<Button>(R.id.bSend)
if (checkSelfPermission(Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
requestPermissions(arrayOf(Manifest.permission.SEND_SMS,
    Manifest.permission.READ_PHONE_STATE),3212)
btnSend.setOnClickListener { 
val smsmanager=getSystemService(SmsManager::class.java)
smsmanager.sendTextMessage(txtNumber.text.toString(),null,txtMessage.text.toString(),null,
    null)
}

    }
}