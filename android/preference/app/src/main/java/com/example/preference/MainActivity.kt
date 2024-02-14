package com.example.preference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtMessage=findViewById<EditText>(R.id.eText)
        val btnLoad=findViewById<Button>(R.id.bLoad)
        val btnSave =findViewById<Button>(R.id.bSave)
        val btnExit=findViewById<Button>(R.id.bExit)
        btnExit.setOnClickListener { finish() }
    btnLoad.setOnClickListener {
    var preference=getSharedPreferences("mydata", Context.MODE_PRIVATE)
    txtMessage.setText(preference.getString("data","no data"))
    }
    btnSave.setOnClickListener {
    var preference=getSharedPreferences("mydata", Context.MODE_PRIVATE)
        preference.edit {
            putString("data",txtMessage.text.toString())
            putInt("data2",1234)
            commit()
        }
    }
    }
}