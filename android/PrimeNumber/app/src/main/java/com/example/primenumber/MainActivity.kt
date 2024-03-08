package com.example.primenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart:Button
    private lateinit var btnCancel:Button
    private lateinit var txtInput:EditText
    private lateinit var txtOutput:TextView
    private lateinit var progressbar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    btnStart=findViewById(R.id.bStart);btnCancel=findViewById(R.id.bCancel);txtInput=findViewById(R.id.eInput)
    txtOutput=findViewById(R.id.tOutput);progressbar=findViewById(R.id.progressBar)
    btnStart.setOnClickListener {
        
    }
    }
}