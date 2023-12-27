package com.example.unitconvertor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val txt1= findViewById<TextView>(R.id.textView1)
    val btn1=findViewById<Button>(R.id.button1)
    val btn2=findViewById<Button>(R.id.button2)
    val textInput1=findViewById<EditText>(R.id.editTextText1)
        txt1.text="CSMJU"

        btn1.setOnClickListener {
            txt1.text=" ${textInput1.text.toString().toFloat()*2.54} cm"
        }
    btn2.setOnClickListener { txt1.text=" ${"%.3f".format(textInput1.text.toString().toFloat()/2.54)} inch" }
        textInput1.setOnClickListener {
            txt1.text= textInput1.text.toString()  }
    val btn3=findViewById<Button>(R.id.button3)
    btn3.setOnClickListener { finish() }

    }
}