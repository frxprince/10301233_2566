package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
 val eInput=findViewById<EditText>(R.id.eInput)
 val btnMetric=findViewById<Button>(R.id.bMetric)
 val tbase=findViewById<TextView>(R.id.tBase)
 val bIEC=findViewById<Button>(R.id.bIEC)
 var inputPrefix:String
 val A3Receiver=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
   result:ActivityResult->if(result.resultCode == RESULT_OK){
   tbase.text=(result.data!!.getDoubleExtra("metric",0.0)
     * eInput.text.toString().toDouble()).toString()
       inputPrefix=result.data?.getStringExtra("name")?:"byte"
   }
 }
 btnMetric.setOnClickListener {
 val i= Intent(this,Activity3::class.java)
 A3Receiver.launch(i)
 }

    }
}