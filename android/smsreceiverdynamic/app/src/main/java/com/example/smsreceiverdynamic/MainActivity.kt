package com.example.smsreceiverdynamic

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.widget.TextView

class MainActivity : AppCompatActivity() {
 lateinit var SMS:SMSReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 if(checkSelfPermission(Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED)
  requestPermissions(arrayOf(Manifest.permission.RECEIVE_SMS),1234)
    val txtMessage=findViewById<TextView>(R.id.tMessage)
  SMS=object:SMSReceiver(){
      override fun show(msg: String) {
          txtMessage.text=msg
      }
  }
    }

    override fun onResume() {
        super.onResume()
    registerReceiver(SMS, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
    }

    override fun onPause() {
        super.onPause()
    unregisterReceiver(SMS)
    }

    abstract class SMSReceiver:BroadcastReceiver(){
     override fun onReceive(context: Context?, intent: Intent?) {
 var message=Telephony.Sms.Intents.getMessagesFromIntent(intent)[0]
  show("From: ${message.displayOriginatingAddress}\nBody:${message.displayMessageBody}")
     }
   abstract fun show(msg:String)
 }
}