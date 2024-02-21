package com.example.sendsms

import android.Manifest
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
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
val sentReceiver=object :SMSSent(){
    override fun show(msg: String) {
     txtStatus.text=txtStatus.text.toString()+"\n"+msg
    }
}
val deliveredReceiver=object:SMSdelivered(){
    override fun show(msg: String) {
        txtStatus.text=txtStatus.text.toString()+"\n"+msg
    }
}
  val deliveredPI=PendingIntent.getBroadcast(this,0,Intent("SMS_DELIVERED"),
      PendingIntent.FLAG_IMMUTABLE)
  val sentPI=PendingIntent.getBroadcast(this,0,Intent("SMS_SENT"),PendingIntent.FLAG_IMMUTABLE)
 registerReceiver(sentReceiver, IntentFilter("SMS_SENT"))
 registerReceiver(deliveredReceiver, IntentFilter("SMS_DELIVERED"))

btnSend.setOnClickListener { 
val smsmanager=getSystemService(SmsManager::class.java)
smsmanager.sendTextMessage(txtNumber.text.toString(),null,txtMessage.text.toString(),sentPI,
    deliveredPI)
}
    }
  abstract class SMSSent:BroadcastReceiver(){
      override fun onReceive(context: Context?, intent: Intent?) {
        when(resultCode){
            RESULT_OK->show("The sms was sent")
            SmsManager.RESULT_ERROR_NO_SERVICE->show("No service")
            SmsManager.RESULT_ERROR_RADIO_OFF->show("Error, the phone is in flight mode")
            else->show("Generic Error")
        }
      }
      abstract fun show(msg:String)
  }
  abstract class SMSdelivered:BroadcastReceiver(){
      override fun onReceive(context: Context?, intent: Intent?) {
        if(resultCode== RESULT_OK){show("Message delivered!")}else{show("Fail")}
      }
      abstract fun show(msg:String)
  }

}