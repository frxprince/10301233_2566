package com.example.implicitintent

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val btnWWW=findViewById<Button>(R.id.bwww)
    val btnMAP=findViewById<Button>(R.id.bmap)
    val btnTimer=findViewById<Button>(R.id.btimer)
    val btnPhonebook=findViewById<Button>(R.id.bphonebook)
 btnWWW.setOnClickListener {
 val i= Intent(Intent.ACTION_VIEW,
     Uri.parse("http://www.csmju.com"))
     try {
         startActivity(i)
     } catch (e: Exception) {
         btnWWW.text="No browser";btnWWW.isEnabled=false
     }
 }
   btnMAP.setOnClickListener {
  val i=Intent(Intent.ACTION_VIEW,Uri.parse("geo:38.8992534,-77.048056"))
  startActivity(i)
   }
if (checkSelfPermission(Manifest.permission.SET_ALARM) != PackageManager.PERMISSION_GRANTED)
 requestPermissions(arrayOf(Manifest.permission.SET_ALARM),1234)
 btnTimer.setOnClickListener {
 val i=Intent(AlarmClock.ACTION_SET_TIMER)
     i.putExtra(AlarmClock.EXTRA_LENGTH,10)
     i.putExtra(AlarmClock.EXTRA_MESSAGE,"Timeout")
     i.putExtra(AlarmClock.EXTRA_SKIP_UI,true)
     startActivity(i)
 }

  btnPhonebook.setOnClickListener {
  val i=Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI)
  startActivityForResult(i,1234)
  }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    Log.v("phonebook",data!!.data.toString())
    }
}